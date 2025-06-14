package com.example.mcapi.SeverShop

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "shop")
data class Shop(
    @Id @Column(name = "shop_code") val shopCode: Int,
    @Column(name = "shop_name", length = 45) val shopName: String
)
