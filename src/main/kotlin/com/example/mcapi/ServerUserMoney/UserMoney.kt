package com.example.mcapi.ServerUserMoney

import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.*

@Entity
@Table(name = "user_money")
data class UserMoney(
    @Id @Column(name = "user_uid") val user: String,
    @Column(name = "money") var balance: Int = 0
)
