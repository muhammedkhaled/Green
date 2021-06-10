package com.muhammad.green.data.network

import com.muhammad.green.base.BaseApi
import com.muhammad.green.views.registration.response.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi : BaseApi {

    @POST("login")
    suspend fun login(
        @Body userLogin: UserLogin
    ): LoginSuccess

    @POST("user/register")
    suspend fun RegisVolUser(
        @Body inputs: RegisUserInputs
    ): RegisUser

    @POST("account/register")
    suspend fun regisNeedUser(
        @Body inputs: RegisUserInputs
    ): RegisUser

    @GET("governments")
    suspend fun governments() : Governments

}
