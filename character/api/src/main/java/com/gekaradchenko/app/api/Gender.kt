package com.gekaradchenko.app.api

import kotlinx.serialization.SerialName

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