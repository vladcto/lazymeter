package com.vladcto.lazymeter.feature.another_api_send_using_retrofit

import com.vladcto.lazymeter.data.lazy.domain.LazyUnit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

// I sketched singletons out of bored.

interface LazyApi {
    @POST(".")
    suspend fun sendLazyUnit(@Body lazyUnit: LazyUnit)
}

object PipeDreamRepository {
    private const val BASE_URL = "https://eohs6jhqt3mt0gf.m.pipedream.net/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val lazyApi: LazyApi = retrofit.create(LazyApi::class.java)

    suspend fun sendLazyUnit(lazyUnit: LazyUnit) {
        try {
            lazyApi.sendLazyUnit(lazyUnit)
        } catch (_: Throwable) {
        }
    }
}