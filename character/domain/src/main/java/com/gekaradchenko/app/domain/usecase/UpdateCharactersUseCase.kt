package com.gekaradchenko.app.domain.usecase

import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.request.Gender
import com.gekaradchenko.app.domain.models.request.Status

interface UpdateCharactersUseCase {
    suspend fun updateCharactersUseCase(
        name: String?,
        status: Status?,
        gender: Gender?
    ): DomainResponse<BaseDomainCollectionResult>
}