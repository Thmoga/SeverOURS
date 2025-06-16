package com.example.mcapi.ServerUserMoney

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "server_equipment")
data class ServerEquipment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_code") var uequipmentCode: Int = 1,
    @Column(name = "equipment_name") val equipmentName: String,
    @Column(name = "equipment_type") val equipmentType: String,
    @Column(name = "equipment_rating") val equipmentRating: String,
    @Column(name = "equipment_have_option") val equipmentHaveOpion: String?,
    @Column(name = "equipment_attach") val equipmentAttach: String?,
    @Column(name = "equipment_icon") val equipmentIcon: String?

)
