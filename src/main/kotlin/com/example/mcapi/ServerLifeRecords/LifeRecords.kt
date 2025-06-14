package com.example.mcapi.ServerLifeRecords

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "life_records")
data class LifeRecords(
    @Id @Column(name = "death_uid") val deathUid: String,
    @Column(name = "death_character", length = 45) val deathCharacter: String,
    @Column(name = "death_class", length = 45) val deathClass: String,
    @Column(name = "death_power") val deathPower: Int,
    @Column(name = "death_level") val deathLevel: Int,
    @Column(name = "death_stat_str") val deathStatStr: Int,
    @Column(name = "death_stat_dex") val deathStatDex: Int,
    @Column(name = "death_stat_int") val deathStatInt: Int,
    @Column(name = "death_stat_wis") val deathStatWis: Int,
    @Column(name = "death_state_hp") val deathStateHp: Int,
    @Column(name = "death_state_mp") val deathStateMp: Int,
    @Column(name = "death_state_exp") val deathStateExp: Int,
    @Column(name = "death_state_record", length = 255) val deathStateRecord: String
)
