package com.gekaradchenko.app.database.mapper

import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.LocationData
import com.gekaradchenko.app.data.models.OriginData
import com.gekaradchenko.app.database.models.CharacterDBO

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