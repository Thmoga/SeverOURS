package com.example.mcapi.ServerFeat

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="server_feat")
data class ServerFeat (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feat_code") val featCode: Int = 1,
    @Column(name = "feat_name") val featName: String,
    @Column(name = "feat_rating") val featRating: String,
    @Column(name = "feat_attach") val featAttach: String,
    @Column(name = "feat_where_get") val featWhereGet: String,
    @Column(name = "feat_image_addres") val featImageAddr: String?
)