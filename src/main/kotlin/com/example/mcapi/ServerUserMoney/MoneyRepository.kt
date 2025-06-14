package com.example.mcapi.ServerUserMoney

import org.springframework.data.jpa.repository.JpaRepository

interface MoneyRepository : JpaRepository<UserMoney, String>
