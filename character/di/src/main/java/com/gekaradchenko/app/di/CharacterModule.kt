package com.gekaradchenko.app.di

import com.gekaradchenko.app.api.CharacterApi
import com.gekaradchenko.app.api.CharacterGateway
import com.gekaradchenko.app.data.CharactersRepositoryImpl
import com.gekaradchenko.app.data.LocalCharacters
import com.gekaradchenko.app.data.RemoteCharacters
import com.gekaradchenko.app.database.ObjectStorage
import com.gekaradchenko.app.domain.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CharacterModule {

    @Provides
    @Singleton
    fun provideCharacterApi(): CharacterApi {
        return CharacterApi("https://rickandmortyapi.com/api")
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
    fun provideLocalCharacters(): LocalCharacters {
        return ObjectStorage
    }

    @Provides
    fun provideCharactersRepository(
        remoteCharacters: RemoteCharacters,
        localCharacters: LocalCharacters,
    ): CharactersRepository {
        return CharactersRepositoryImpl(
            remoteCharacters, localCharacters
        )
    }
}