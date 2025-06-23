package com.example.mcapi.ServerUserStat

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class StatRequest(
    val uuid: String,
    val stat: String,
    val amount: Int
)

data class StatValueResponse(val value: Int)

@RestController
@RequestMapping("/api/stat")
@CrossOrigin("38291")
class StatController(private val service: StatService) {

    @GetMapping
    fun getAllStats(): ResponseEntity<List<UserStat>> {
        return ResponseEntity.ok(service.getAllStats())
    }

    @GetMapping("/{uuid}")
    fun getStat(
        @PathVariable uuid: String,
        @RequestParam stat: String
    ): ResponseEntity<StatValueResponse> {
        return try {
            val result = service.getStat(uuid, stat)
            ResponseEntity.ok(StatValueResponse(result))
        } catch (e: IllegalArgumentException) {
            ResponseEntity.badRequest().build()
        }
    }

    @PostMapping("/add")
    fun addStat(@RequestBody request: StatRequest): ResponseEntity<UserStat> {
        return ResponseEntity.ok(service.modifyStat(request, "add"))
    }

    @PostMapping("/decrease")
    fun decreaseStat(@RequestBody request: StatRequest): ResponseEntity<UserStat> {
        return ResponseEntity.ok(service.modifyStat(request, "decrease"))
    }

    @PostMapping("/set")
    fun setStat(@RequestBody request: StatRequest): ResponseEntity<UserStat> {
        return ResponseEntity.ok(service.modifyStat(request, "set"))
    }
}
