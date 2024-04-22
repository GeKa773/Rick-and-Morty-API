package com.gekaradchenko.app.data

import kotlinx.serialization.Serializable

@Serializable
data class BaseDataCollectionModel<T>(
    val info: InfoData,
    val result: List<T>
)

@Serializable
data class InfoData(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)