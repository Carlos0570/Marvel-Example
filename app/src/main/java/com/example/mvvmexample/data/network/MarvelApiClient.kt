package com.example.mvvmexample.data.network
import com.example.mvvmexample.data.model.Comic
import com.example.mvvmexample.data.model.SuperHero
import com.example.mvvmexample.data.model.base.MarvelResponse
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApiClient {

    @GET("characters")
    suspend fun getAllSuperHeroes(): MarvelResponse<SuperHero>

    @GET("comics")
    suspend fun getAllComics(@Query ("limit") limit : Int = 100): MarvelResponse<Comic>

    @GET("comics/{comicID}/characters")
    suspend fun getSuperHeroByComicID(@Path ("comicID")comicID : String): MarvelResponse<SuperHero>
}