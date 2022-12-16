package com.example.mvvmexample.data

import com.example.mvvmexample.data.model.Comic
import com.example.mvvmexample.data.model.SuperHero
import com.example.mvvmexample.data.network.MarvelService
import javax.inject.Inject

class MarvelRepository @Inject constructor(private val api: MarvelService) {

    suspend fun getAllSuperHeroes(): List<SuperHero> = api.getAllSuperHeroes()

    suspend fun getAllSuperHeroesByComicId(comicId: String): List<SuperHero> =
        api.getSuperHeroesByComicID(comicId)

    suspend fun getAllComics(): List<Comic> = api.getAllComics()
}