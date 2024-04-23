package com.gekaradchenko.app.api

import com.gekaradchenko.app.api.mapper.characterMapper
import com.gekaradchenko.app.api.mapper.toDTO
import com.gekaradchenko.app.api.mapper.toDataCollectionModel
import com.gekaradchenko.app.api.mapper.toDataResponse
import com.gekaradchenko.app.data.BaseDataCollectionModel
import com.gekaradchenko.app.data.DataResponse
import com.gekaradchenko.app.data.RemoteCharacters
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.remote.GenderData
import com.gekaradchenko.app.data.models.remote.StatusData

class CharacterGateway(private val characterApi: CharacterApi) : RemoteCharacters {
    override suspend fun getCharacters(
        page: Int,
        name: String?,
        status: StatusData?,
        gender: GenderData?
    ): DataResponse<BaseDataCollectionModel<CharacterData>> {
        return characterApi.getCharacters(page, name, status?.toDTO(), gender?.toDTO())
            .toDataResponse { it.toDataCollectionModel { characterMapper(it) } }
    }

    override suspend fun getCharacter(id: Int): DataResponse<CharacterData> {
        return characterApi.getCharacter(id).toDataResponse { characterMapper(it) }
    }

}