package com.gekaradchenko.app.di

import android.content.Context
import com.gekaradchenko.app.api.CharacterApi
import com.gekaradchenko.app.api.CharacterGateway
import com.gekaradchenko.app.data.CharactersRepositoryImpl
import com.gekaradchenko.app.data.LocalCharacters
import com.gekaradchenko.app.data.RemoteCharacters
import com.gekaradchenko.app.database.CharacterDataBaseDataBase
import com.gekaradchenko.app.domain.repository.CharactersRepository
import com.gekaradchenko.app.object_storage.ObjectStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CharacterModule {

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json
    }

    @Provides
    @Singleton
    fun provideCharacterApi(): CharacterApi {
        return CharacterApi("https://rickandmortyapi.com/api/")
    }

    @Provides
    @Singleton
    fun provideRemoteCharacters(
        characterApi: CharacterApi,
    ): RemoteCharacters {
        return CharacterGateway(characterApi)
    }

    @Provides
    @Singleton
    @Named("database")
    fun provideLocalCharactersDataBase(
        @ApplicationContext appContext: Context,
        json: Json,
    ): LocalCharacters {
        return CharacterDataBaseDataBase(appContext, json)
    }

    @Provides
    @Singleton
    @Named("object_storage")
    fun provideLocalCharactersObjectStorage(): LocalCharacters {
        return ObjectStorage
    }

    @Provides
    fun provideCharactersRepository(
        remoteCharacters: RemoteCharacters,
        @Named("database") localCharacters: LocalCharacters,
    ): CharactersRepository {
        return CharactersRepositoryImpl(
            remoteCharacters, localCharacters
        )
    }
}