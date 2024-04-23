package com.gekaradchenko.app.domain.models.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Gender {
    @SerialName("female")
    FEMALE,

    @SerialName("male")
    MALE,

    @SerialName("genderless")
    GENDERLESS,

    @SerialName("unknown")
    UNKNOWN
}