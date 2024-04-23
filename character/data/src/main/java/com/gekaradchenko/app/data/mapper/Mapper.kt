package com.gekaradchenko.app.data.mapper

import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.LocationData
import com.gekaradchenko.app.data.models.OriginData
import com.gekaradchenko.app.data.models.remote.GenderData
import com.gekaradchenko.app.data.models.remote.StatusData
import com.gekaradchenko.app.domain.models.request.Gender
import com.gekaradchenko.app.domain.models.request.Status
import com.gekaradchenko.app.domain.models.response.Character
import com.gekaradchenko.app.domain.models.response.Location
import com.gekaradchenko.app.domain.models.response.Origin

internal fun characterMapper(characterData: CharacterData): Character {
    return Character(
        id = characterData.id,
        name = characterData.name,
        status = characterData.status,
        species = characterData.species,
        type = characterData.type,
        gender = characterData.gender,
        origin = characterData.origin.toDomain(),
        location = characterData.location.toDomain(),
        image = characterData.image,
        episode = characterData.episode,
        url = characterData.url,
        created = characterData.created,
    )
}

internal fun characterMapper(character: Character): CharacterData {
    return CharacterData(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = character.origin.toData(),
        location = character.location.toData(),
        image = character.image,
        episode = character.episode,
        url = character.url,
        created = character.created,
    )
}

private fun OriginData.toDomain(): Origin {
    return Origin(
        name = this.name,
        url = this.url,
    )
}

private fun LocationData.toDomain(): Location {
    return Location(
        name = this.name,
        url = this.url,
    )
}

private fun Origin.toData(): OriginData {
    return OriginData(
        name = this.name,
        url = this.url,
    )
}

private fun Location.toData(): LocationData {
    return LocationData(
        name = this.name,
        url = this.url,
    )
}

internal fun Status.toData(): StatusData {
    return when (this) {
        Status.ALIVE -> StatusData.ALIVE
        Status.DEAD -> StatusData.DEAD
        Status.UNKNOWN -> StatusData.UNKNOWN
    }
}

internal fun Gender.toData(): GenderData {
    return when (this) {
        Gender.FEMALE -> GenderData.FEMALE
        Gender.MALE -> GenderData.MALE
        Gender.GENDERLESS -> GenderData.GENDERLESS
        Gender.UNKNOWN -> GenderData.UNKNOWN
    }
}