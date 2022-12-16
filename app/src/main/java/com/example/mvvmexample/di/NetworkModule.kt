package com.example.mvvmexample.di

import com.example.mvvmexample.data.network.MarvelApiClient
import com.example.mvvmexample.data.network.MarvelInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://gateway.marvel.com/v1/public/"

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideHttpClient(): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(MarvelInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideMarvelAPI(retrofit: Retrofit): MarvelApiClient {
        return retrofit.create(MarvelApiClient::class.java)
    }
}