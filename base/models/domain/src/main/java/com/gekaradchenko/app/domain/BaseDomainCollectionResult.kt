package com.gekaradchenko.app.domain

import kotlinx.serialization.Serializable

@Serializable
data class BaseDomainCollectionResult(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?,
)