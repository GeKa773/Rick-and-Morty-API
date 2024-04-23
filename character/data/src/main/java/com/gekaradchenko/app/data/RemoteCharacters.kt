package com.gekaradchenko.app.data

import androidx.annotation.IntRange
import com.gekaradchenko.app.data.models.CharacterData
import com.gekaradchenko.app.data.models.remote.GenderData
import com.gekaradchenko.app.data.models.remote.StatusData

    interface RemoteCharacters {

    fun getCharacters(
        @IntRange(from = 1) page: Int,
        name: String? = null,
        status: StatusData? = null,
        gender: GenderData? = null,
    ): DataResponse<BaseDataCollectionModel<CharacterData>>

    fun getCharacter(
        id: Int
    ): DataResponse<CharacterData>
}