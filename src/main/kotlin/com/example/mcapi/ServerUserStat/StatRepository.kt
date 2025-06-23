package com.example.mcapi.ServerUserStat

import org.springframework.data.jpa.repository.JpaRepository

interface StatRepository : JpaRepository<UserStat, String>
