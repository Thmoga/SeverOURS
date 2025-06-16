package com.example.mcapi.ServerUserPower

import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user_power")
data class UserPower(
    @Id @OneToOne @JoinColumn(name = "user_uid") val uid: UserInformation,
    @Column(name="user_combat_power") val userCombatPower: Int,
    @Column(name = "user_attack_damage") var userAttackDamage: Int,
    @Column(name = "user_health") var userHealth: Int,
    @Column(name = "user_defense") var userDefense: Int,
    @Column(name = "user_mana") var userMana: Int,
    @Column(name = "user_skill_damage") var userSkillDamage: Int,
    @Column(name = "user_critical") var userCritical: Int,
    @Column(name = "user_critical_damage") var userCriticalDamage: Int
)
