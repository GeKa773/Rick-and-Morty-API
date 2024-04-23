package com.gekaradchenko.app.data

import com.gekaradchenko.app.data.mapper.characterMapper
import com.gekaradchenko.app.data.mapper.toData
import com.gekaradchenko.app.data.mapper.toDomainCollectionModel
import com.gekaradchenko.app.data.mapper.toDomainResponse
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.repository.CharactersRepository
import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.request.Gender
import com.gekaradchenko.app.domain.models.request.Status
import com.gekaradchenko.app.domain.models.response.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharactersRepositoryImpl(
    private val remoteCharacters: RemoteCharacters,
    private val localCharacters: LocalCharacters,
) : CharactersRepository {
    override fun connectLocalCharacters(): Flow<List<Character>> {
        return localCharacters.getAllLocalCharacters().map { list -> list.map { item -> characterMapper(item) } }
    }

    override suspend fun getLocalCharacterById(id: Int): Character? {
        return localCharacters.getLocalCharacter(id)?.let { characterMapper(it) }
    }

    override suspend fun saveLocalCharacters(characters: List<Character>): Boolean {
        return localCharacters.saveLocalCharacters(characters.map { characterMapper(it) })
    }

    override suspend fun clearLocalCharacters(): Boolean {
        return localCharacters.clearLocalCharacters()
    }

    override suspend fun getRemotePageCharacters(
        page: Int,
        name: String?,
        status: Status?,
        gender: Gender?
    ): Pair<DomainResponse<BaseDomainCollectionResult>, List<Character>?> {

        val result: DataResponse<BaseDataCollectionModel<CharacterData>> =
            remoteCharacters.getCharacters(page, name, status?.toData(), gender?.toData())

        val response: DomainResponse<BaseDomainCollectionResult> =
            result.toDomainResponse { it.toDomainCollectionModel { characterMapper(it) } }

        val characters = result.body?.result?.map { characterMapper(it) }

        return Pair(response, characters)
    }

    override suspend fun getRemoteCharacterById(id: Int): DomainResponse<Character> {
        return remoteCharacters.getCharacter(id).toDomainResponse { characterMapper(it) }
    }
}

