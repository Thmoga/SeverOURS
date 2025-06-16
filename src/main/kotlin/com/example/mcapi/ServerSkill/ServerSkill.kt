package com.example.mcapi.ServerSkill

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "server_skill")
data class ServerSkill(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_code") val skillCode: Int = 1,
    @Column(name = "skill_name") val skillName: String,
    @Column(name = "skill_type") val skillType: String,
    @Column(name = "skill_rating") val skillRating: String?,
    @Column(name = "skill_attach") val skillAttach: String?,
    @Column(name = "skill_image_address", length = 255) val skillImageAddress: String?
)