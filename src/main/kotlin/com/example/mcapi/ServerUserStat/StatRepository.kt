package com.example.mcapi.ServerUserStat

import com.example.mcapi.ServerUserInformation.UserInformation
import org.springframework.data.jpa.repository.JpaRepository

interface StatRepository : JpaRepository<UserStat, UserInformation>
