package com.gekaradchenko.app.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)