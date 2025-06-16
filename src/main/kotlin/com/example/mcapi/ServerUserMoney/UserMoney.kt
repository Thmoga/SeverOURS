package com.example.mcapi.ServerUserMoney

import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user_money")
data class UserMoney(
    @Id @OneToOne @JoinColumn(name = "user_uid") val userUID: UserInformation,
    @Column(name="money") var balance: Int = 0
)
