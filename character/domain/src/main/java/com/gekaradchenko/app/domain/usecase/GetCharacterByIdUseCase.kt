package com.gekaradchenko.app.domain.usecase

import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.response.Character

interface GetCharacterByIdUseCase {
   suspend fun getCharacter(id: Int): DomainResponse<Character>
}