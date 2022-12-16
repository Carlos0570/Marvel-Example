package com.example.mvvmexample.data.network

import com.example.mvvmexample.data.model.Comic
import com.example.mvvmexample.data.model.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarvelService @Inject constructor(private val api: MarvelApiClient) {

    suspend fun getAllSuperHeroes(): List<SuperHero> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllSuperHeroes()
            response.data.results.toList()
        }
    }

    suspend fun getAllComics(): List<Comic> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllComics()
            response.data.results.toList()
                .sortedByDescending { it.characters?.items.isNullOrEmpty().not() }
                .filter {
                    it.thumbnail?.path?.contains("image_not_available")?.not() ?: false
                }
        }
    }

    suspend fun getSuperHeroesByComicID(comicID: String): List<SuperHero> {
        return withContext(Dispatchers.IO) {
            val response = api.getSuperHeroByComicID(comicID)
            response.data.results
        }
    }
}