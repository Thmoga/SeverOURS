package com.example.mcapi.ServerUserTakeEquipment

import com.example.mcapi.ServerUserInformation.UserInformation
import com.example.mcapi.ServerUserMoney.ServerEquipment
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="user_take_equipment")
data class UserTakeEquipment(
    @Id@ManyToOne @JoinColumn(name="user_uid") val userUid : UserInformation,
    @Column (name = "equipment_slot") val equipmentSlot : String,
    @ManyToOne @JoinColumn(name ="equipment_code") val equipmentCode : ServerEquipment
)