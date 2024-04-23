package com.gekaradchenko.app.data

import com.gekaradchenko.app.data.models.CharacterData
import kotlinx.coroutines.flow.Flow

interface LocalCharacters {

    fun getAllLocalCharacters(): Flow<List<CharacterData>>

    suspend fun getLocalCharacter(id: Int): CharacterData?

    suspend fun saveLocalCharacters(characters: List<CharacterData>): Boolean

    suspend fun clearLocalCharacters(): Boolean
}