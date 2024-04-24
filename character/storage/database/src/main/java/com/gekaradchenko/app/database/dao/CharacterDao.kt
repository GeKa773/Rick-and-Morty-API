package com.gekaradchenko.app.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import com.gekaradchenko.app.database.models.CharacterDBO
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterDBO>>

    @Query("SELECT * FROM characters WHERE id IN (:characterId)")
    suspend fun getCharacter(characterId: Int): CharacterDBO?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characters: List<CharacterDBO>)

    @Delete
    suspend fun remove(characters: List<CharacterDBO>)

    @Query("DELETE FROM characters")
    suspend fun clear()
}