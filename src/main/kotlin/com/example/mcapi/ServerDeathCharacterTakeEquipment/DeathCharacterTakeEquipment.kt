package com.example.mcapi.ServerDeathCharacterTakeEquipment


import com.example.mcapi.ServerUserMoney.ServerEquipment
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="death_character_take_equipment")
data class DeathCharacterTakeEquipment(
    @Id @Column(name="death_character_slot") var deathCharacterSlot: String?,
    @Column(name="life_count") var lifeCount: Int,
    @ManyToOne @JoinColumn(name="server_equipment_code") var EquipmentCode: ServerEquipment,
    @Column (name="equipment_records") var equipmentRecords: String?
)