package com.gekaradchenko.app.domain.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Status {
    @SerialName("alive")
    ALIVE,

    @SerialName("dead")
    DEAD,

    @SerialName("unknown")
    UNKNOWN
}