package com.gekaradchenko.app.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseApiCollectionModel<T>(
    @SerialName("info") val info: InfoDTO,
    @SerialName("results") val result: List<T>

)

@Serializable
data class InfoDTO(
    @SerialName("count") val count: Int,
    @SerialName("pages") val pages: Int,
    @SerialName("next") val next: String?,
    @SerialName("prev") val prev: String?,
)