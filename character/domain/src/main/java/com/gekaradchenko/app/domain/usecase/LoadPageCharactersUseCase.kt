package com.gekaradchenko.app.domain.usecase

import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.request.Gender
import com.gekaradchenko.app.domain.models.request.Status

interface LoadPageCharactersUseCase {

    suspend fun loadPageCharactersUseCase(
        page: Int,
        name: String? = null,
        status: Status? = null,
        gender: Gender? = null
    ): DomainResponse<BaseDomainCollectionResult>
}