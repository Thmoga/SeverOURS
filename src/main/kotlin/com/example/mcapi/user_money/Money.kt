package com.example.mcapi.user_money

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Money(
    @Id val uuid: String,
    var balance: Int = 0
)
