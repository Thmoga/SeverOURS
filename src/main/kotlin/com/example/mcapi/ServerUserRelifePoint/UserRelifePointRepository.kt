package com.example.mcapi.ServerUserRelifePoint

import com.example.mcapi.ServerUserInformation.UserInformation
import org.springframework.data.jpa.repository.JpaRepository

interface UserRelifePointRepository : JpaRepository<UserInformation, String>
