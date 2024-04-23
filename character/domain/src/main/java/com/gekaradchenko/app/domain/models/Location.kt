package com.gekaradchenko.app.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String,
)
