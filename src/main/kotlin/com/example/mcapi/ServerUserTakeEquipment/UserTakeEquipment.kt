package com.example.mcapi.ServerUserTakeEquipment

import com.example.mcapi.ServerDeathCharacterTakeEquipment.DeathCharEquipId
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "user_take_equipment")
data class UserTakeEquipment(
    @EmbeddedId val pk: DeathCharEquipId,
    @Column(name = "slot_number") val slotNumber: Int,
    @Column(name = "record") val record: String?
)

@Embeddable
data class UserEquipId(
    @Column(name = "death_character") val deathChar: String,
    @Column(name = "user_uid") val uid: String,
    @Column(name = "server_equipment_code") val equipmentCode: Int
) : Serializable
