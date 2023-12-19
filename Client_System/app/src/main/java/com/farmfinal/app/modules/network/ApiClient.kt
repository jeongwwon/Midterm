package com.farmfinal.app.modules.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.farmfinal.app.modules.network.ApiService

object ApiClient {
    private const val BASE_URL = "http://jeongwon2.pythonanywhere.com/"

    fun createApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}
