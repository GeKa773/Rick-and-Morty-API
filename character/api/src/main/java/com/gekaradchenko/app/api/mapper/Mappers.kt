package com.gekaradchenko.app.api.mapper

import com.gekaradchenko.app.api.models.request.GenderDTO
import com.gekaradchenko.app.api.models.request.StatusDTO
import com.gekaradchenko.app.api.models.response.CharacterDTO
import com.gekaradchenko.app.api.models.response.LocationDTO
import com.gekaradchenko.app.api.models.response.OriginDTO
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.LocationData
import com.gekaradchenko.app.data.models.OriginData
import com.gekaradchenko.app.data.models.remote.GenderData
import com.gekaradchenko.app.data.models.remote.StatusData


internal fun StatusData.toDTO(): StatusDTO {
    return when (this) {
        StatusData.ALIVE -> StatusDTO.ALIVE
        StatusData.DEAD -> StatusDTO.DEAD
        StatusData.UNKNOWN -> StatusDTO.UNKNOWN
    }
}

internal fun GenderData.toDTO(): GenderDTO {
    return when (this) {
        GenderData.FEMALE -> GenderDTO.FEMALE
        GenderData.MALE -> GenderDTO.MALE
        GenderData.GENDERLESS -> GenderDTO.GENDERLESS
        GenderData.UNKNOWN -> GenderDTO.UNKNOWN
    }
}

internal fun characterMapper(characterDTO: CharacterDTO): CharacterData {
    return CharacterData(
        id = characterDTO.id,
        name = characterDTO.name,
        status = characterDTO.status,
        species = characterDTO.species,
        type = characterDTO.type,
        gender = characterDTO.gender,
        origin = characterDTO.origin.toData(),
        location = characterDTO.location.toData(),
        image = characterDTO.image,
        episode = characterDTO.episode,
        url = characterDTO.url,
        created = characterDTO.created,
    )
}

private fun OriginDTO.toData(): OriginData {
    return OriginData(
        name = this.name,
        url = this.url,
    )
}

private fun LocationDTO.toData(): LocationData {
    return LocationData(
        name = this.name,
        url = this.url,
    )
}
