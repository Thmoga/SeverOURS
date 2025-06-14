package com.example.mcapi.ServerUserMoney

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "server_equipment")
data class ServerEquipment(
    @Id @Column(name = "equipment_code") var uequipmentCode: Int,
    @Column(name = "equipment_name") val equipmentName: String,
    @Column(name = "equipment_desc") val equipmentDesc: String,
    @Column(name = "equipment_arg1") val equipmentArg1: String?,
    @Column(name = "equipment_arg2") val equipmentArg2: String?,
    @Column(name = "equipment_arg3") val equipmentArg3: String?,
    @Column(name = "equipment_icon") val equipmentIcon: String?

)
