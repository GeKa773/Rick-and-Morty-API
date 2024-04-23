package com.gekaradchenko.app.domain

import kotlinx.serialization.Serializable

@Serializable
data class DomainResponse<T>(
    val isSuccessful: Boolean,
    val code: Int,
    val message: String,
    val body: T?
)