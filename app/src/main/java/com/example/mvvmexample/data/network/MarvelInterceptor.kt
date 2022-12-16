package com.example.mvvmexample.data.network

import com.example.mvvmexample.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class MarvelInterceptor () : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url()
            .newBuilder()
            .addQueryParameter(API_KEY_NAME, BuildConfig.API_KEY)
            .addQueryParameter(HAS_NAME, BuildConfig.HASH)
            .addQueryParameter(TS_NAME, BuildConfig.TS)
            .build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }

    companion object {
        private const val API_KEY_NAME = "apikey"
        private const val HAS_NAME = "hash"
        private const val TS_NAME = "ts"
    }
}