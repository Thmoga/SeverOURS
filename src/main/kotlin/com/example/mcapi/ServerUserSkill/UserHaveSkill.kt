package com.example.mcapi.ServerUserSkill

import com.example.mcapi.ServerSkill.ServerSkill
import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user_have_skill")
data class UserHaveSkill(
    @Id @ManyToOne @JoinColumn(name = "user_uid") val userUID: UserInformation,
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_have_count") val skillHaveCount: Int = 1,
    @ManyToOne @JoinColumn(name = "skill_code") val skill: ServerSkill
)
