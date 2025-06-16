package com.example.mcapi.ServerShopItem

import org.springframework.data.jpa.repository.JpaRepository

interface ShopItemRepository : JpaRepository<ShopItem, String>
