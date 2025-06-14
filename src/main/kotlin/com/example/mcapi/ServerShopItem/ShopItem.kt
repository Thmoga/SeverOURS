package com.example.mcapi.ServerShopItem

import com.example.mcapi.ServerItem.ServerItem
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "shop_item")
data class ShopItem(
    @Id @Column(name = "shop_item_code") val shopItemCode: Int,
    @ManyToOne
    @JoinColumn(name = "item_code") val serverItem: ServerItem,
    @Column(name = "shop_item_price") val price: Int
)
