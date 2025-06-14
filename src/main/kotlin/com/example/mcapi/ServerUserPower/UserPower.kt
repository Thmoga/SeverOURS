package com.example.mcapi.ServerUserPower

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_power")
data class UserPower(
    @Id @Column(name = "user_uid") val uid: String,
    @Column(name = "user_attack") var attack: Int,
    @Column(name = "user_hp") var hp: Int,
    @Column(name = "user_max_hp") var maxHp: Int,
    @Column(name = "user_def") var def: Int,
    @Column(name = "user_mdef") var mdef: Int
)
