package com.example.mcapi.UserSynthesisStat

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_synthesis_stat")
data class UserSynthesisStat(
    @Id @Column(name = "user_uid") val uuid: String,
    @Column(name="stat") var Stat: Int,
    @Column(name="str") var STR: Int,
    @Column(name = "wis") var WIS: Int,
    @Column(name = "sen") var SEN: Int,
    @Column(name = "vit") var VIT: Int,
    @Column(name = "end") var END: Int,
    @Column(name="mnd") var MND: Int,
)
