package com.gekaradchenko.app.api.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class GenderDTO {
    @SerialName("female")
    FEMALE,

    @SerialName("male")
    MALE,

    @SerialName("genderless")
    GENDERLESS,

    @SerialName("unknown")
    UNKNOWN
}