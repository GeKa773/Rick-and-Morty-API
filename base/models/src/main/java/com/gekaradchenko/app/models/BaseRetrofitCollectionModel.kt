package com.gekaradchenko.app.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseRetrofitCollectionModel<T>(
    @SerialName("info") val info: Info,
    @SerialName("result") val result: List<T>

)

@Serializable
data class Info(
    @SerialName("count") val count: Int,
    @SerialName("pages") val pages: Int,
    @SerialName("next") val next: String?,
    @SerialName("prev") val prev: String?,
)