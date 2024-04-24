package com.gekaradchenko.app.object_storage.mapper

import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.LocationData
import com.gekaradchenko.app.data.models.OriginData
import com.gekaradchenko.app.object_storage.models.CharacterDBO

internal fun characterMapper(characterDBO: CharacterDBO): CharacterData {
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
        episode = characterDBO.episode,
        url = characterDBO.url,
        created = characterDBO.created,
    )

}

internal fun characterMapper(characterData: CharacterData): CharacterDBO {
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
        episode = characterData.episode,
        url = characterData.url,
        created = characterData.created,
    )

}