package com.ticonsys.kotlinretrofit.retrofit

import com.ticonsys.kotlinretrofit.model.LoginResponse

import com.ticonsys.kotlinretrofit.model.NoticeModels

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("api/v1/login")
    fun userLogin(
        @Field("username") email:String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @POST("api/v1/noticeboard")
    fun getNoticeData(
        @Field("eid") eid:String
    ):Call<NoticeModels>
}