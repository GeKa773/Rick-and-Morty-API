package com.gekaradchenko.app.domain.models.response

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,
    val url: String,
)
