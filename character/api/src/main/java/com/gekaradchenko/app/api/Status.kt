package com.gekaradchenko.app.api

import kotlinx.serialization.SerialName

enum class Status {
    @SerialName("alive")
    ALIVE,

    @SerialName("dead")
    DEAD,

    @SerialName("unknown")
    UNKNOWN
}