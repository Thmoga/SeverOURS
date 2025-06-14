package com.example.mcapi.ServerUserMoney

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_money")
data class UserMoney(
    @Id @Column(name = "user_uid") val uuid: String,
    @Column(name="money") var balance: Int = 0
)
