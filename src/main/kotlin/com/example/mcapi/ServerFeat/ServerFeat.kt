package com.example.mcapi.ServerFeat

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="server_feat")
data class ServerFeat (
    @Id @Column(name = "feat_code") val featCode: Int,
    @Column(name = "feat_name", length = 45) val featName: String,
    @Column(name = "feat_desc", length = 255) val featDesc: String,
    @Column(name = "feat_image_addr", length = 255) val featImageAddr: String?
)