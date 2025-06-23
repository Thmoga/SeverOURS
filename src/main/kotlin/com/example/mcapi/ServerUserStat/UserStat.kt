package com.example.mcapi.ServerUserStat

import jakarta.persistence.*

@Entity
@Table(name = "user_stat")
data class UserStat(
    @Id @Column(name = "user_uid") val uid: String,

    @Column(name = "user_have_stat") var Stat: Int = 0,
    @Column(name = "user_have_str") var STR: Int = 0,
    @Column(name = "user_have_wis") var WIS: Int = 0,
    @Column(name = "user_have_sen") var SEN: Int = 0,
    @Column(name = "user_have_vit") var VIT: Int = 0,
    @Column(name = "user_have_end") var END: Int = 0,
    @Column(name = "user_have_mnd") var MND: Int = 0
)
