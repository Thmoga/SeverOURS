package com.example.mcapi.ServerSkill

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "server_skill")
data class ServerSkill(
    @Id @Column(name = "skill_code") val skillCode: Int,
    @Column(name = "skill_name", length = 45) val skillName: String,
    @Column(name = "skill_desc", length = 255) val skillDesc: String,
    @Column(name = "skill_finish", length = 45) val skillFinish: String?,
    @Column(name = "skill_image_addr", length = 255) val skillImageAddr: String?
)