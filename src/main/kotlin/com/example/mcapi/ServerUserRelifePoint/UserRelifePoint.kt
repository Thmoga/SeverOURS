package com.example.mcapi.ServerUserRelifePoint

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "user_relife_point")
data class UserRelifePoint(
    @Id @Column(name = "user_uid") val uid: String,
    @Column(name = "relife_point") var relifePoint: Int
)
