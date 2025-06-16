package com.example.mcapi.ServerEquipment

import com.example.mcapi.ServerUserMoney.ServerEquipment
import org.springframework.data.jpa.repository.JpaRepository

interface SeverEquipmentRepository : JpaRepository<ServerEquipment, String>
