package com.example.mcapi.ServerUserMoney

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class MoneyRequest(val uuid: String, val amount: Int)

@RestController
@RequestMapping("/api/money")
@CrossOrigin("38291")
class MoneyController(private val service: MoneyService) {

    @GetMapping
    fun getAllMoney(): ResponseEntity<List<UserMoney>> {
        return ResponseEntity.ok(service.getAllMoney())
    }

    @GetMapping("/{uuid}")
    fun getMoney(@PathVariable uuid: String): ResponseEntity<UserMoney> {
        return ResponseEntity.ok(service.getMoney(uuid))
    }

    @PostMapping("/add")
    fun addMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        return ResponseEntity.ok(service.modifyMoney(request.uuid, request.amount, "add"))
    }

    @PostMapping("/pay")
    fun payMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        return try {
            ResponseEntity.ok(service.modifyMoney(request.uuid, request.amount, "pay"))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping("/set")
    fun setMoney(@RequestBody request: MoneyRequest): ResponseEntity<UserMoney> {
        return ResponseEntity.ok(service.modifyMoney(request.uuid, request.amount, "set"))
    }
}
