package com.gekaradchenko.app.data.models.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GenderData {
    @SerialName("female")
    FEMALE,

    @SerialName("male")
    MALE,

    @SerialName("genderless")
    GENDERLESS,

    @SerialName("unknown")
    UNKNOWN
}
