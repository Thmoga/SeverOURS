package com.example.mcapi.ServerUserMoney

import org.springframework.stereotype.Service

@Service
class MoneyService(private val repo: MoneyRepository) {

    fun getAllMoney(): List<UserMoney> = repo.findAll()

    fun getMoney(uuid: String): UserMoney {
        return repo.findById(uuid).orElseGet {
            repo.save(UserMoney(user = uuid, balance = 0))
        }
    }

    fun modifyMoney(uuid: String, amount: Int, mode: String): UserMoney {
        val money = repo.findById(uuid).orElse(UserMoney(user = uuid, balance = 0))

        when (mode) {
            "add" -> money.balance += amount
            "pay" -> {
                if (money.balance < amount) throw IllegalArgumentException("잔액 부족")
                money.balance -= amount
            }
            "set" -> money.balance = amount
            else -> throw IllegalArgumentException("잘못된 mode")
        }

        return repo.save(money)
    }
}
