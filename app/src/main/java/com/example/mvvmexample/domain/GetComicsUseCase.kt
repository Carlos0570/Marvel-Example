package com.example.mvvmexample.domain

import com.example.mvvmexample.data.MarvelRepository
import com.example.mvvmexample.data.model.Comic
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(private val marvelRepository: MarvelRepository) {
    suspend operator fun invoke(): List<Comic>  = marvelRepository.getAllComics()
}

