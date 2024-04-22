package com.gekaradchenko.app.data.models.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class StatusData {
    @SerialName("alive")
    ALIVE,

    @SerialName("dead")
    DEAD,

    @SerialName("unknown")
    UNKNOWN
}
