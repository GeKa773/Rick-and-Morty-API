package com.gekaradchenko.app.domain.usecase

import com.gekaradchenko.app.domain.BaseDomainCollectionResult
import com.gekaradchenko.app.domain.DomainResponse
import com.gekaradchenko.app.domain.models.request.Gender
import com.gekaradchenko.app.domain.models.request.Status
import com.gekaradchenko.app.domain.repository.CharactersRepository
import com.gekaradchenko.app.domain.models.response.Character
import kotlinx.coroutines.flow.Flow

class CharacterUseCase(private val repository: CharactersRepository) : GetCharactersUseCase,
    LoadPageCharactersUseCase,
    UpdateCharactersUseCase,
    GetCharacterByIdUseCase {
    override fun getCharactersUseCase(): Flow<List<Character>> {
        return repository.connectLocalCharacters()
    }

    override suspend fun loadPageCharactersUseCase(
        page: Int,
        name: String?,
        status: Status?,
        gender: Gender?
    ): DomainResponse<BaseDomainCollectionResult> {
        val result = repository.getRemotePageCharacters(page, name, status, gender)
        if (result.first.isSuccessful && result.first.body != null && result.second != null) {

            repository.saveLocalCharacters(result.second!!)
        }
        return result.first
    }

    override suspend fun updateCharactersUseCase(
        name: String?,
        status: Status?,
        gender: Gender?
    ): DomainResponse<BaseDomainCollectionResult> {
        val result = repository.getRemotePageCharacters(1, name, status, gender)
        if (result.first.isSuccessful && result.first.body != null && result.second != null) {
            repository.clearLocalCharacters()
            repository.saveLocalCharacters(result.second!!)
        }
        return result.first
    }

    override suspend fun getCharacter(id: Int): DomainResponse<Character> {
        val local = repository.getLocalCharacterById(id)
        return if (local != null) {
            DomainResponse(
                isSuccessful = true,
                code = 200,
                message = "",
                body = local
            )
        } else {
            repository.getRemoteCharacterById(id)
        }
    }
}