package com.example.mcapi.ServerDeathCharacterTakeEquipment


import com.example.mcapi.ServerUserMoney.ServerEquipment
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table

//@Entity
//@Table(name = "death_character_take_equipment")
//data class DeathCharacterTakeEquipment(
//    @EmbeddedId val pk: DeathCharEquipId,
//    @Column(name = "slot_number") val slotNumber: Int,
//    @Column(name = "record") val record: String?
//)
//
//@Embeddable
//data class DeathCharEquipId(
//    @Column(name = "death_character") val deathChar: String,
//    @Column(name = "user_uid") val uid: String,
//    @Column(name = "server_equipment_code") val equipmentCode: Int
//) : Serializable

@Entity
@Table(name="death_character_take_equipment")
data class DeathCharacterTakeEquipment(
    @Id @Column(name="death_character_slot") var deathCharacterSlot: String?,
    @Column(name="life_count") var lifeCount: Int,
    @JoinColumn(name="server_equipment_code") var EquipmentCode: ServerEquipment,
    @Column (name="equipment_records") var equipmentRecords: String?
)