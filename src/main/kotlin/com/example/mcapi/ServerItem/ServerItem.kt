package com.example.mcapi.ServerItem

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "server_item")
data class ServerItem(
    @Id @Column(name = "item_code") val itemCode: Int,
    @Column(name = "item_name", length = 45) val itemName: String,
    @Column(name = "item_desc", length = 255) val itemDesc: String,
    @Column(name = "item_image_addr", length = 255) val itemImageAddr: String?
)
