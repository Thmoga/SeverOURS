package com.example.mcapi.user_stat

import jakarta.persistence.Entity
import jakarta.persistence.Id
//힘 : STR / 지혜 : WIS / 오감 : SEN / 체력 : VIT / 지구력 : END / 정신력 : MND
@Entity
data class Stat(
    @Id val uuid: String,
    var Stat: Int = 0,
    var STR: Int = 0,
    var WIS: Int = 0,
    var SEN: Int = 0,
    var VIT: Int = 0,
    var END: Int = 0,
    var MND: Int = 0
)

data class StatValueResponse(val value: Int = 0)
