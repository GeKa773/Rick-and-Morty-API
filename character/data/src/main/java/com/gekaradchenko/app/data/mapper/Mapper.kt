package com.gekaradchenko.app.data.mapper

import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.LocationData
import com.gekaradchenko.app.data.models.OriginData
import com.gekaradchenko.app.domain.models.Character
import com.gekaradchenko.app.domain.models.Location
import com.gekaradchenko.app.domain.models.Origin

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