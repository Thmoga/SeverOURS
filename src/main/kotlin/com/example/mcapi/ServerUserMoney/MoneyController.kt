package com.example.mcapi.ServerUserMoney

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class MoneyRequest(val uuid: String, val amount: Int)

@RestController
@RequestMapping("/api/money")
@CrossOrigin("38291") //공유될 포트나 도메인 주소, 즉 *이면 아무나 상관없음, 특정포트를 쓰면 됨
class MoneyController(private val repo: MoneyRepository) {

    @GetMapping("/{uuid}")
    fun getMoney(@PathVariable uuid: String): ResponseEntity<UserMoney> {
        val money = repo.findById(uuid).orElseGet {
            val newMoney = UserMoney(uuid, 0)
            repo.save(newMoney)
        }
        return ResponseEntity.ok(money)
    }

    @PostMapping("/add")
    fun addMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        val money = repo.findById(request.uuid).orElse(UserMoney(request.uuid, 0))
        money.balance += request.amount
        return ResponseEntity.ok(repo.save(money))
    }

    @PostMapping("/pay")
    fun payMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        val money = repo.findById(request.uuid).orElse(UserMoney(request.uuid, 0))
        if (money.balance < request.amount) {
            return ResponseEntity.badRequest().build()
        }
        money.balance -= request.amount
        return ResponseEntity.ok(repo.save(money))
    }

    @PostMapping("/set")
    fun setMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        val money = repo.findById(request.uuid).orElse(UserMoney(request.uuid, 0))
        if (money.balance < request.amount) {
            return ResponseEntity.badRequest().build()
        }
        money.balance = request.amount
        return ResponseEntity.ok(repo.save(money))
    }
}
