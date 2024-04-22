package com.gekaradchenko.app.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterData(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginData,
    val location: LocationData,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
)
