package com.gekaradchenko.app.domain

interface CharactersRepository {

    fun connectLocalCharacters()

    fun getPageCharacters()

    fun getCharacter()
}