package com.gekaradchenko.app.api.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class StatusDTO {
    @SerialName("alive")
    ALIVE,

    @SerialName("dead")
    DEAD,

    @SerialName("unknown")
    UNKNOWN
}