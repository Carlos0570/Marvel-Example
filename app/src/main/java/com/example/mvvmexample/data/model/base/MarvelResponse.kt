package com.example.mvvmexample.data.model.base

data class MarvelResponse<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: Data<T>,
    val etag: String,
    val status: String
)