package com.gekaradchenko.app.presentation

import androidx.lifecycle.ViewModel
import com.gekaradchenko.app.domain.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

}