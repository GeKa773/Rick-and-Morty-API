package com.gekaradchenko.app.data

interface CharactersRepository {

    fun connectLocalCharacters()

    fun getPageCharacters()

    fun getCharacter()
}