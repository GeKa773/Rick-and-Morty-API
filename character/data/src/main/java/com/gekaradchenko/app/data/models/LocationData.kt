package com.gekaradchenko.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class LocationData(
    val name: String,
    val url: String
)
