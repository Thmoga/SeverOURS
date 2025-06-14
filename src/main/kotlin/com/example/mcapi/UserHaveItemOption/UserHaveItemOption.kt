package com.example.mcapi.UserHaveItemOption

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "user_have_item_option")
data class UserHaveItemOption(
    @EmbeddedId val pk: UserItemOptionId,
    @Column(name = "option_value", length = 45) val optionValue: String
)

@Embeddable
data class UserItemOptionId(
    @Column(name = "user_uid") val uid: String,
    @Column(name = "user_item_option") val optionCode: Int
) : Serializable
