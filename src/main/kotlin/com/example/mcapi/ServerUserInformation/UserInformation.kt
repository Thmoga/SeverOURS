package com.example.mcapi.ServerUserInformation

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_information")
data class UserInformation(
    @Id @Column(name = "user_uid") val uid: String,
    @Column(name = "player_name", length = 45) var playerName: String,
    @Column(name = "create_time") var createTime: String,
    @Column(name = "level") var level: Int = 0,
    @Column(name = "death_count") var deathCount: Int = 0,
    @Column(name = "tribe", length = 45) var tribe: String
)
