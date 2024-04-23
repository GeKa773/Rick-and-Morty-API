package com.gekaradchenko.app.di

import com.gekaradchenko.app.domain.repository.CharactersRepository
import com.gekaradchenko.app.domain.usecase.CharacterUseCase
import com.gekaradchenko.app.domain.usecase.GetCharacterByIdUseCase
import com.gekaradchenko.app.domain.usecase.GetCharactersUseCase
import com.gekaradchenko.app.domain.usecase.LoadPageCharactersUseCase
import com.gekaradchenko.app.domain.usecase.UpdateCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CharacterUseCaseModule {

    @Provides
    fun provideGetCharactersUseCase(
        repository: CharactersRepository
    ): GetCharactersUseCase {
        return CharacterUseCase(repository)
    }

    @Provides
    fun provideLoadPageCharactersUseCase(
        repository: CharactersRepository
    ): LoadPageCharactersUseCase {
        return CharacterUseCase(repository)
    }

    @Provides
    fun provideUpdateCharactersUseCase(
        repository: CharactersRepository
    ): UpdateCharactersUseCase {
        return CharacterUseCase(repository)
    }

    @Provides
    fun provideGetCharacterByIdUseCase(
        repository: CharactersRepository
    ): GetCharacterByIdUseCase {
        return CharacterUseCase(repository)
    }
}