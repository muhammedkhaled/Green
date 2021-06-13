package com.muhammad.green.data.network

import com.muhammad.green.base.BaseApi
import com.muhammad.green.views.landing.response.IntroResponse
import retrofit2.http.GET

interface IntroApi : BaseApi{

    @GET("home")
    suspend fun getIntroData() : IntroResponse
}