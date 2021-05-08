package com.muhammad.green.data.repository

import com.muhammad.green.base.BaseApi
import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.response.UserLogin
import net.simplifiedcoding.data.UserPreferences

class AuthRepository(private val api: AuthApi, private val preferences: UserPreferences) : BaseRepository(api){

    suspend fun login(
        password: String,
        phone: String,
        ) = safeApiCall {
        api.login(phone, password)
    }

    suspend fun login(
        userLogin: UserLogin
    ) = safeApiCall {
        api.login(userLogin)
    }

    suspend fun saveAuthToken(token: String){
        preferences.saveAccessTokens(token)
    }

}