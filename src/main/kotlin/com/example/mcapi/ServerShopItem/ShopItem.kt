package com.example.mcapi.ServerShopItem

import com.example.mcapi.ServerItem.ServerItem
import com.example.mcapi.SeverShop.Shop
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "shop_item")
data class ShopItem(
    @Id @ManyToOne @JoinColumn(name = "shop_code") val shopCode: Shop,
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_have_item_count") var shopHaveItemCount: Int = 1,
    @ManyToOne @JoinColumn(name = "shop_item_code") val serverItem: ServerItem,
    @Column(name = "shop_item_purchase_price") val shopItemPurchasePrice: Int,
    @Column(name = "shop_item_sell_price") val shopItemSellPrice: Int
)
