package com.gekaradchenko.app.data

import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.CharactersRepository
import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.Character
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val remoteCharacters: RemoteCharacters,
    private val localCharacters: LocalCharacters
) : CharactersRepository {
    override fun connectLocalCharacters(): Flow<List<Character>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPageCharacters(): DomainResponse<BaseDomainCollectionResult> {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacter(): DomainResponse<Character> {
        TODO("Not yet implemented")
    }
}