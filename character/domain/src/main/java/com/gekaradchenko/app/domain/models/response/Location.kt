package com.gekaradchenko.app.domain.models.response

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String,
)
