package com.example.countlories.data.api

import com.example.countlories.data.response.LoginResponse
import com.example.countlories.data.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>
}