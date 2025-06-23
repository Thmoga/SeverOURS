package com.example.mcapi.ServerUserStat

import com.example.mcapi.ServerUserInformation.UserInformationRepository
import org.springframework.stereotype.Service

@Service
class StatService(
    private val repo: StatRepository,
    private val userInfoRepo: UserInformationRepository
) {

    fun getAllStats(): List<UserStat> = repo.findAll()

    fun getStat(uuid: String, stat: String): Int {
        val user = userInfoRepo.findById(uuid)
            .orElseThrow { NoSuchElementException("User not found: $uuid") }

        val userStat = repo.findById(user.uid).orElseGet {
            repo.save(UserStat(uid = user.uid))
        }

        return when (stat) {
            "힘" -> userStat.STR
            "지혜" -> userStat.WIS
            "오감" -> userStat.SEN
            "체력" -> userStat.VIT
            "지구력" -> userStat.END
            "정신력" -> userStat.MND
            "스텟" -> userStat.Stat
            else -> throw IllegalArgumentException("Invalid stat: $stat")
        }
    }

    fun modifyStat(request: StatRequest, mode: String): UserStat {
        userInfoRepo.findById(request.uuid)
            .orElseThrow { NoSuchElementException("User not found: ${request.uuid}") }

        val stat = repo.findById(request.uuid).orElse(UserStat(uid = request.uuid))

        val value = request.amount
        when (request.stat) {
            "스텟" -> stat.Stat = update(stat.Stat, value, mode)
            "힘" -> stat.STR = update(stat.STR, value, mode)
            "지혜" -> stat.WIS = update(stat.WIS, value, mode)
            "오감" -> stat.SEN = update(stat.SEN, value, mode)
            "체력" -> stat.VIT = update(stat.VIT, value, mode)
            "지구력" -> stat.END = update(stat.END, value, mode)
            "정신력" -> stat.MND = update(stat.MND, value, mode)
            else -> throw IllegalArgumentException("Invalid stat: ${request.stat}")
        }

        return repo.save(stat)
    }

    private fun update(original: Int, amount: Int, mode: String): Int = when (mode) {
        "add" -> original + amount
        "decrease" -> (original - amount).coerceAtLeast(0)
        "set" -> amount
        else -> throw IllegalArgumentException("Invalid mode: $mode")
    }
}
//이것도 업로드 되야 하는데