package com.example.mcapi.user_money

import org.springframework.data.jpa.repository.JpaRepository

interface MoneyRepository : JpaRepository<Money, String>
