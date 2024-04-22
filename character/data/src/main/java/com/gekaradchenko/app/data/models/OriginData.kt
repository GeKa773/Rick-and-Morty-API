package com.gekaradchenko.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class OriginData(
    val name: String,
    val url: String
)