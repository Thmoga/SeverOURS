package com.example.mcapi.ServerItem

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "server_item")
data class ServerItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_code") val itemCode: Int = 1,
    @Column(name = "item_name") val itemName: String,
    @Column(name = "item_attach") val itemAttach: String,
    @Column(name = "item_image_address",) val itemImageAddress: String?
)
