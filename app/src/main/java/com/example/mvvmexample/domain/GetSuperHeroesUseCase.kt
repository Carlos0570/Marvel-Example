package com.example.mvvmexample.domain

import com.example.mvvmexample.data.MarvelRepository
import com.example.mvvmexample.data.model.SuperHero
import javax.inject.Inject

class GetSuperHeroesUseCase @Inject constructor(private val repository: MarvelRepository) {

    suspend operator fun invoke(): List<SuperHero> = repository.getAllSuperHeroes()
}