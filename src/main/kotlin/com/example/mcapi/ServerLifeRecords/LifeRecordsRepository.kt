package com.example.mcapi.ServerLifeRecords

import org.springframework.data.jpa.repository.JpaRepository

interface LifeRecordsRepository : JpaRepository<LifeRecords, String>
