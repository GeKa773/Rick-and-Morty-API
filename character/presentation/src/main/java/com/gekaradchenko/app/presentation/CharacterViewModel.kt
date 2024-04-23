package com.gekaradchenko.app.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gekaradchenko.app.domain.models.response.Character
import com.gekaradchenko.app.domain.repository.CharactersRepository
import com.gekaradchenko.app.domain.usecase.GetCharactersUseCase
import com.gekaradchenko.app.domain.usecase.LoadPageCharactersUseCase
import com.gekaradchenko.app.domain.usecase.UpdateCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val loadPageCharactersUseCase: LoadPageCharactersUseCase,
    private val updateCharactersUseCase: UpdateCharactersUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<List<Character>> = MutableStateFlow(listOf())
    val uiState: StateFlow<List<Character>> = _uiState.asStateFlow()

    private var page = 1


    init {
        viewModelScope.launch(context = Dispatchers.IO) {
            getCharactersUseCase.getCharactersUseCase().collectLatest {
                _uiState.value = it
            }
        }
    }

    fun updateList() {
        viewModelScope.launch(context = Dispatchers.IO) {
            val result = loadPageCharactersUseCase.loadPageCharactersUseCase(page = page)
            page++

            Log.e("updateList", "updateList  result -> ${result.toString()}")
        }
    }

}