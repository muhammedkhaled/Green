package com.muhammad.green.data.network

import com.muhammad.green.BuildConfig
import com.muhammad.green.base.BaseApi
import com.muhammad.green.data.network.response.LoginSuccess
import com.muhammad.green.data.network.response.UserLogin
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

private const val BASE_URL = "http://khatwa-lelganna.com/api/"


interface AuthApi : BaseApi {
    @Multipart
    @POST("login")
    suspend fun login(
        @Part("password") password: String,
        @Part("phone") phone: String
    ): LoginSuccess

    @POST("login")
    suspend fun login(
        @Body userLogin: UserLogin
    ): LoginSuccess
}



object RemoteDataSource {

    fun <Api> buildApi(
        api: Class<Api>,
        authToken: String? = null
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        chain.proceed(chain.request().newBuilder().also {
                            it.addHeader("Authorization", "Bearer $authToken")
                        }.build())
                    }.also { client ->
                        if (BuildConfig.DEBUG) {
                            val logging = HttpLoggingInterceptor()
                            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                            client.addInterceptor(logging)
                        }
                    }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

}