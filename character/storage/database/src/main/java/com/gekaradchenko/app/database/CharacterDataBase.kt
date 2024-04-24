package com.gekaradchenko.app.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gekaradchenko.app.data.LocalCharacters
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.database.dao.CharacterDao
import com.gekaradchenko.app.database.mapper.characterMapper
import com.gekaradchenko.app.database.models.CharacterDBO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json

@Database(entities = [CharacterDBO::class], version = 1)
internal abstract class DataBase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao
}

class CharacterDataBaseDataBase(application: Context, private val json: Json) : LocalCharacters {

    private val db = Room.databaseBuilder(application, DataBase::class.java, "character-database").build()
    private val characterDao = db.characterDao()
    override fun getAllLocalCharacters(): Flow<List<CharacterData>> {
        return characterDao.getAll().map { it.map { character -> characterMapper(character, json) } }
    }

    override suspend fun getLocalCharacter(id: Int): CharacterData? {
        return try {
            val theCharacter = characterDao.getCharacter(id)?.let { characterMapper(it, json) }
            theCharacter

        } catch (e: Exception) {
            Log.e(TAG, "getLocalCharacter exception -> ${e.localizedMessage}")
            null
        }
    }

    override suspend fun saveLocalCharacters(characters: List<CharacterData>): Boolean {
        return try {
            characterDao.insert(characters.map { characterMapper(it, json) })
            true

        } catch (e: Exception) {
            Log.e(TAG, "saveLocalCharacters exception -> ${e.localizedMessage}")
            false
        }
    }

    override suspend fun clearLocalCharacters(): Boolean {
        return try {
            characterDao.clear()
            true
        } catch (e: Exception) {
            Log.e(TAG, "clearLocalCharacters exception -> ${e.localizedMessage}")
            false
        }
    }


    companion object {
        private const val TAG = "CharacterDataBaseDataBase"
    }
}

