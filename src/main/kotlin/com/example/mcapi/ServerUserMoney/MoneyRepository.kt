package com.example.mcapi.ServerUserMoney

import com.example.mcapi.ServerUserInformation.UserInformation
import org.springframework.data.jpa.repository.JpaRepository

interface MoneyRepository : JpaRepository<UserMoney, UserInformation>
