package com.gekaradchenko.app.domain

import com.gekaradchenko.app.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun connectLocalCharacters(): Flow<List<Character>>

    suspend fun getPageCharacters(): DomainResponse<BaseDomainCollectionResult>

    suspend fun getCharacter(): DomainResponse<Character>
}