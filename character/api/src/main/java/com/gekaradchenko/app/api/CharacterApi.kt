package com.gekaradchenko.app.api

import androidx.annotation.IntRange
import com.gekaradchenko.app.api.models.Character
import com.gekaradchenko.app.models.BaseRetrofitCollectionModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    /**
     *  API details [here](https://rickandmortyapi.com/documentation/#get-all-characters)
     */

    @GET("/character")
    fun getCharacters(
        @Query("page") @IntRange(from = 1) page: Int,
        @Query("name") name: String? = null,
        @Query("status") status: Status? = null,
        @Query("gender") gender: Gender? = null,
    ): Result<BaseRetrofitCollectionModel<Character>>


    /**
     *  API details [here](https://rickandmortyapi.com/documentation/#get-a-single-character)
     */

    @GET("character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Result<Character>

}

fun CharacterApi(baseUrl: String): CharacterApi {
    val retrofit = retrofit(baseUrl)
    return retrofit.create(CharacterApi::class.java)
}

private fun retrofit(baseUrl: String): Retrofit {
    val jsonConverterFactory = Json.asConverterFactory(MediaType.get("application/json"))
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .build()
}
