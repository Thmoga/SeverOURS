package com.example.mcapi.ServerLifeRecords

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "life_records")
data class LifeRecords(
    @Id @Column(name = "death_uid") val deathUid: String,
    @Column(name = "death_time") val deathTime: String,
    @Column(name = "death_tribe") val deathTribe: String,
    @Column(name = "death_power") val deathPower: Int,
    @Column(name = "death_attack_damage") val deathAttackDamage: Int,
    @Column(name = "death_defense") val deathDefense: Int,
    @Column(name = "death_health") val deathHealth: Int,
    @Column(name = "death_mana") val deathMana: Int,
    @Column(name = "death_skill_damage") val deathSkillDamage: Int,
    @Column(name = "death_critical") val deathCritical: Int,
    @Column(name = "death_critical_damage") val deathCriticalDamage: Int,
    @Column(name = "death_str") val deathSTR: Int,
    @Column(name = "death_wis") val deathWIS: Int,
    @Column(name = "death_sen") val deathSEN: Int,
    @Column(name = "death_vit") val deathVIT: Int,
    @Column(name = "death_end") val deathEND: Int,
    @Column(name = "death_mnd") val deathMND: Int
)
