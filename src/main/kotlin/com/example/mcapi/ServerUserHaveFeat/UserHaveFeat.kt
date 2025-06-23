package com.example.mcapi.ServerUserHaveFeat

import com.example.mcapi.ServerFeat.ServerFeat
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
@Table(name = "user_have_feat")
data class UserHaveFeat(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") val id: Int = 1,
    @ManyToOne @JoinColumn(name = "user_uid") val userUid: UserInformation,
    @ManyToOne @JoinColumn(name = "user_have_feat") val userFeat: ServerFeat
)
