package com.gekaradchenko.app.database

import com.gekaradchenko.app.data.LocalCharacters
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.database.mapper.characterMapper
import com.gekaradchenko.app.database.models.CharacterDBO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map

object ObjectStorage : LocalCharacters {

    private val characters: Flow<List<CharacterDBO>> = flowOf(listOf())
    override fun getAllLocalCharacters(): Flow<List<CharacterData>> {
        return characters.map { it.map { character -> characterMapper(character) } }
    }

    override suspend fun getLocalCharacter(id: Int): CharacterData? {
        characters.last().forEach { dbo ->
            if (dbo.id == id) return characterMapper(dbo)
        }

        return null
    }

}