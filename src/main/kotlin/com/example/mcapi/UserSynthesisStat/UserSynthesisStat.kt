package com.example.mcapi.UserSynthesisStat

import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user_synthesis_stat")
data class UserSynthesisStat(
    @Id @OneToOne @JoinColumn(name = "user_uid") val userUid: UserInformation,
    @Column (name = "user_synthesis_stat") var synthesisStat: Int = 0,
    @Column (name = "user_synthesis_str") var synthesisSTR: Int = 0,
    @Column (name = "user_synthesis_wis") var synthesisWIS: Int = 0,
    @Column (name = "user_synthesis_sen") var synthesisSEN: Int = 0,
    @Column (name = "user_synthesis_vit") var synthesisVIT: Int = 0,
    @Column (name = "user_synthesis_end") var synthesisEND: Int = 0,
    @Column (name = "user_synthesis_mnd") var synthesisMND: Int = 0
)

data class SymthesisStatValueResponse(val synthesisValue: Int = 0)