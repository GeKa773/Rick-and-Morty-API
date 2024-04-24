package com.gekaradchenko.app.object_storage

import com.gekaradchenko.app.data.LocalCharacters
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.object_storage.mapper.characterMapper
import com.gekaradchenko.app.object_storage.models.CharacterDBO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map

object ObjectStorage : LocalCharacters {

    private val characters: MutableStateFlow<List<CharacterDBO>> = MutableStateFlow(listOf())
    override fun getAllLocalCharacters(): Flow<List<CharacterData>> {
        return characters.map { it.map { character -> characterMapper(character) } }
    }

    override suspend fun getLocalCharacter(id: Int): CharacterData? {
        characters.last().forEach { dbo ->
            if (dbo.id == id) return characterMapper(dbo)
        }

        return null
    }

    override suspend fun saveLocalCharacters(characters: List<CharacterData>): Boolean {
        this.characters.value = characters.map { characterMapper(it) }
        return true
    }

    override suspend fun clearLocalCharacters(): Boolean {
        this.characters.value = listOf()

        return true
    }

}