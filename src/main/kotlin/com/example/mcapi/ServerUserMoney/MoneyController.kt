package com.example.mcapi.ServerUserMoney

import com.example.mcapi.ServerUserInformation.UserInformationRepository
import com.example.mcapi.ServerUserInformation.UserInformation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class MoneyRequest(val uuid: String, val amount: Int)

@RestController
@RequestMapping("/api/money")
@CrossOrigin("38291")
class MoneyController(
    private val repo: MoneyRepository,
    private val userInfoRepo: UserInformationRepository
) {

    @GetMapping("/{uuid}")
    fun getMoney(@PathVariable uuid: String): ResponseEntity<UserMoney> {
        val userInfo = userInfoRepo.findById(uuid)
            .orElseThrow { NoSuchElementException("User not found: $uuid") }

        val money = repo.findById(userInfo).orElseGet {
            val newMoney = UserMoney(userUID = userInfo, balance = 0)
            repo.save(newMoney)
        }

        return ResponseEntity.ok(money)
    }

    @PostMapping("/add")
    fun addMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        val userInfo = userInfoRepo.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val money = repo.findById(userInfo).orElse(UserMoney(userUID = userInfo, balance = 0))
        money.balance += request.amount
        return ResponseEntity.ok(repo.save(money))
    }

    @PostMapping("/pay")
    fun payMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        val userInfo = userInfoRepo.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val money = repo.findById(userInfo).orElse(UserMoney(userUID = userInfo, balance = 0))
        if (money.balance < request.amount) {
            return ResponseEntity.badRequest().build()
        }

        money.balance -= request.amount
        return ResponseEntity.ok(repo.save(money))
    }

    @PostMapping("/set")
    fun setMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        val userInfo = userInfoRepo.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val money = repo.findById(userInfo).orElse(UserMoney(userUID = userInfo, balance = 0))
        money.balance = request.amount
        return ResponseEntity.ok(repo.save(money))
    }
}
