package com.example.mcapi.UserHaveItemOption

import com.example.mcapi.ServerUserInformation.UserInformation
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name="user_have_item_option")
data class UserHaveItemOption(
    @JoinColumn(name="user_uid") val userUid : UserInformation,
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_have_option_count") var userHaveOptionCount : Int,
    @Column(name="equiption_option_name") val equipmentOptionName : String,
    @Column(name="equiption_option_value") var equipmentOptionValue : Int
)