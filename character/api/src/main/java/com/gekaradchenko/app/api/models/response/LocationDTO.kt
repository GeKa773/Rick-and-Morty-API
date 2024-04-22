package com.gekaradchenko.app.api.models.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDTO(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)