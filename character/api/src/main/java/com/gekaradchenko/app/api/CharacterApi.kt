package com.gekaradchenko.app.api

import androidx.annotation.IntRange
import com.gekaradchenko.app.api.models.request.GenderDTO
import com.gekaradchenko.app.api.models.request.StatusDTO
import com.gekaradchenko.app.api.models.response.CharacterDTO
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface CharacterApi {

    /**
     *  API details [here](https://rickandmortyapi.com/documentation/#get-all-characters)
     */

    @GET("character")
    suspend fun getCharacters(
        @Query("page") @IntRange(from = 1) page: Int,
        @Query("name") name: String? = null,
        @Query("status") status: StatusDTO? = null,
        @Query("gender") gender: GenderDTO? = null,
    ): Response<BaseApiCollectionModel<CharacterDTO>>


    /**
     *  API details [here](https://rickandmortyapi.com/documentation/#get-a-single-character)
     */

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): Response<CharacterDTO>

}

fun CharacterApi(baseUrl: String): CharacterApi {
    val retrofit = retrofit(baseUrl)
    return retrofit.create(CharacterApi::class.java)
}

private fun retrofit(baseUrl: String): Retrofit {
//    val jsonConverterFactory = Json.asConverterFactory(MediaType.get("application/json"))
    val jsonConverterFactory = Json.asConverterFactory("application/json".toMediaType())
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
//        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(getOkHttpClient())
        .build()
}


private fun getOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .build()
}

private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}
