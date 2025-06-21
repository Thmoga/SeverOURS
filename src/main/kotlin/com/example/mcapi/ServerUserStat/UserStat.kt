package com.example.mcapi.ServerUserStat

import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

//힘 : STR / 지혜 : WIS / 오감 : SEN / 체력 : VIT / 지구력 : END / 정신력 : MND
@Entity
data class UserStat(
    @Id @OneToOne @JoinColumn(name = "user_uid") val userInformation: UserInformation,
    @Column (name = "user_have_stat") var Stat: Int = 0,
    @Column (name = "user_have_str") var STR: Int = 0,
    @Column (name = "user_have_wis") var WIS: Int = 0,
    @Column (name = "user_have_sen") var SEN: Int = 0,
    @Column (name = "user_have_vit") var VIT: Int = 0,
    @Column (name = "user_have_end") var END: Int = 0,
    @Column (name = "user_have_mnd") var MND: Int = 0
)

data class StatValueResponse(val value: Int)
