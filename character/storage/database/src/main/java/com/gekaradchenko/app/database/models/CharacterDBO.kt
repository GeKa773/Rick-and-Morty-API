package com.gekaradchenko.app.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "characters")
data class CharacterDBO(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "originName") val originName: String,
    @ColumnInfo(name = "originUrl") val originUrl: String,
    @ColumnInfo(name = "locationName") val locationName: String,
    @ColumnInfo(name = "locationUrl") val locationUrl: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "episode") val episodeJson: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "created") val created: String,
)
