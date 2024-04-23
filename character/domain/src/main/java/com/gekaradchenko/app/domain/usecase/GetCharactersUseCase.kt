package com.gekaradchenko.app.domain.usecase

import com.gekaradchenko.app.domain.models.response.Character
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {

    fun getCharactersUseCase(): Flow<List<Character>>
}