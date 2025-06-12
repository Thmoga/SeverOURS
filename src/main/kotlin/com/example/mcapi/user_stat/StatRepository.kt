package com.example.mcapi.user_stat

import org.springframework.data.jpa.repository.JpaRepository

interface StatRepository : JpaRepository<Stat, String>
