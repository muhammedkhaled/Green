package com.muhammad.green.data.network

import com.muhammad.green.base.BaseApi
import com.muhammad.green.views.home.response.AboutUs
import com.muhammad.green.views.home.response.Notifications
import retrofit2.http.GET

interface GeneralDataApi : BaseApi {

    @GET("general-settings/management-word")
    suspend fun getManagementWord(): AboutUs

    @GET("general-settings/about-us")
    suspend fun getAboutUs(): AboutUs

    @GET("general-settings/contact-us")
    suspend fun getContactUs(): AboutUs

    @GET("notifications")
    suspend fun getNotifications(): Notifications

}