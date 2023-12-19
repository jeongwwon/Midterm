package com.farmfinal.app.modules.network

import com.farmfinal.app.modules.list.data.model.IntruderListItem
import com.farmfinal.app.modules.login.data.model.ResponseModel2
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.farmfinal.app.modules.signup.data.model.SignUpRequest
import com.farmfinal.app.modules.signup.data.model.ResponseModel
import com.farmfinal.app.modules.login.data.model.loginRequest
import com.farmfinal.app.modules.main.data.model.todResponseModel
import com.farmfinal.app.modules.main.data.model.totResponseModel
import com.farmfinal.app.modules.list.data.model.IntruderListResponseModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @POST("mobile_register/")
    fun signUp(@Body signUpRequest: SignUpRequest): Call<ResponseModel>

    @POST("mobile_login/")
    fun login(@Body loginRequest : loginRequest): Call<ResponseModel2>

    @GET("get_global_count/")
    fun total(): Call<totResponseModel>

    @GET("get_today_count/")
    fun today(): Call<todResponseModel>

    @GET("get_post_list/")
    fun getPostList(): Call<List<IntruderListItem>>

    companion object {
        const val BASE_URL = "https://jeongwon2.pythonanywhere.com/"
        fun createDefault(): ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
            }
}
