package com.gekaradchenko.app.database.mapper

import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.LocationData
import com.gekaradchenko.app.data.models.OriginData
import com.gekaradchenko.app.database.models.CharacterDBO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

internal fun characterMapper(characterDBO: CharacterDBO, json: Json): CharacterData {
    return CharacterData(
        id = characterDBO.id,
        name = characterDBO.name,
        status = characterDBO.status,
        species = characterDBO.species,
        type = characterDBO.type,
        gender = characterDBO.gender,
        origin = OriginData(
            name = characterDBO.originName,
            url = characterDBO.originUrl
        ),
        location = LocationData(
            name = characterDBO.locationName,
            url = characterDBO.locationUrl
        ),
        image = characterDBO.image,
        episode = json.decodeFromString(characterDBO.episodeJson),
        url = characterDBO.url,
        created = characterDBO.created,
    )

}

internal fun characterMapper(characterData: CharacterData, json: Json): CharacterDBO {
    return CharacterDBO(
        id = characterData.id,
        name = characterData.name,
        status = characterData.status,
        species = characterData.species,
        type = characterData.type,
        gender = characterData.gender,
        originName = characterData.origin.name,
        originUrl = characterData.origin.url,
        locationName = characterData.location.name,
        locationUrl = characterData.location.url,
        image = characterData.image,
        episodeJson = json.encodeToString(characterData.episode),
        url = characterData.url,
        created = characterData.created,
    )

}