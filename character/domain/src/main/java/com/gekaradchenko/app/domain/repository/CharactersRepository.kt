package com.gekaradchenko.app.domain.repository

import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.request.Gender
import com.gekaradchenko.app.domain.models.request.Status
import com.gekaradchenko.app.domain.models.response.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun connectLocalCharacters(): Flow<List<Character>>

    suspend fun getLocalCharacterById(id:Int): Character?
    suspend fun saveLocalCharacters(characters: List<Character>): Boolean
    suspend fun clearLocalCharacters(): Boolean
    suspend fun getRemotePageCharacters(
        page: Int,
        name: String?,
        status: Status?,
        gender: Gender?
    ): Pair<DomainResponse<BaseDomainCollectionResult>, List<Character>?>

    suspend fun getRemoteCharacterById(id: Int): DomainResponse<Character>

}