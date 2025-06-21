package com.example.mcapi.ServerUserStat

import com.example.mcapi.ServerUserInformation.UserInformationRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

data class StatRequest(
    val uuid: String,
    val stat: String,
    val amount: Int
)

@RestController
@RequestMapping("/api/stat")
@CrossOrigin("38291")
class StatController(
    private val repo: StatRepository,
    private val userInformationRepository: UserInformationRepository
) {

    @GetMapping("/{uuid}")
    fun getStat(
        @PathVariable uuid: String,
        @RequestParam stat: String
    ): ResponseEntity<StatValueResponse> {
        val userInfo = userInformationRepository.findById(uuid)
            .orElseThrow { NoSuchElementException("User not found: $uuid") }

        val userStat = repo.findById(userInfo).orElseGet {
            repo.save(UserStat(userInformation = userInfo))
        }

        val result = when (stat) {
            "힘" -> userStat.STR
            "지혜" -> userStat.WIS
            "오감" -> userStat.SEN
            "체력" -> userStat.VIT
            "지구력" -> userStat.END
            "정신력" -> userStat.MND
            "스텟" -> userStat.Stat
            else -> return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(StatValueResponse(result))
    }

    @PostMapping("/add")
    fun addStat(@RequestBody request: StatRequest): ResponseEntity<UserStat> {
        val userInfo = userInformationRepository.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val stat = repo.findById(userInfo).orElse(UserStat(userInformation = userInfo))

        when (request.stat) {
            "스텟" -> stat.Stat += request.amount
            "힘" -> stat.STR += request.amount
            "지혜" -> stat.WIS += request.amount
            "오감" -> stat.SEN += request.amount
            "체력" -> stat.VIT += request.amount
            "지구력" -> stat.END += request.amount
            "정신력" -> stat.MND += request.amount
            else -> return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(repo.save(stat))
    }

    @PostMapping("/decrease")
    fun decreaseStat(@RequestBody request: StatRequest): ResponseEntity<UserStat> {
        val userInfo = userInformationRepository.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val stat = repo.findById(userInfo).orElse(UserStat(userInformation = userInfo))

        when (request.stat) {
            "스텟" -> stat.Stat = (stat.Stat - request.amount).coerceAtLeast(0)
            "힘" -> stat.STR = (stat.STR - request.amount).coerceAtLeast(0)
            "지혜" -> stat.WIS = (stat.WIS - request.amount).coerceAtLeast(0)
            "오감" -> stat.SEN = (stat.SEN - request.amount).coerceAtLeast(0)
            "체력" -> stat.VIT = (stat.VIT - request.amount).coerceAtLeast(0)
            "지구력" -> stat.END = (stat.END - request.amount).coerceAtLeast(0)
            "정신력" -> stat.MND = (stat.MND - request.amount).coerceAtLeast(0)
            else -> return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(repo.save(stat))
    }

    @PostMapping("/set")
    fun setStat(@RequestBody request: StatRequest): ResponseEntity<UserStat> {
        val userInfo = userInformationRepository.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val stat = repo.findById(userInfo).orElse(UserStat(userInformation = userInfo))

        when (request.stat) {
            "스텟" -> stat.Stat = request.amount
            "힘" -> stat.STR = request.amount
            "지혜" -> stat.WIS = request.amount
            "오감" -> stat.SEN = request.amount
            "체력" -> stat.VIT = request.amount
            "지구력" -> stat.END = request.amount
            "정신력" -> stat.MND = request.amount
            else -> return ResponseEntity.badRequest().build()
        }

        return ResponseEntity.ok(repo.save(stat))
    }
}
