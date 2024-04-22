package com.gekaradchenko.app.data

import kotlinx.serialization.Serializable

@Serializable
data class DataResponse<T>(
    val code: Int,
    val message: String,
    val body: T?
)
