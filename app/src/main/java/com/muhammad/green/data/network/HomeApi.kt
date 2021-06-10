package com.muhammad.green.data.network

import com.muhammad.green.base.BaseApi
import com.muhammad.green.views.home.response.MyCases
import com.muhammad.green.views.home.response.VisitorHomeData
import retrofit2.http.GET

interface HomeApi : BaseApi {

    @GET("user/profile")
    suspend fun getMyCases() : MyCases

    @GET("home/home-2")
    suspend fun visitorHomeData(): VisitorHomeData
}
