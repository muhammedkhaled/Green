package com.muhammad.green.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.muhammad.green.base.BaseApi
import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.PreferenceHelper.get
import com.muhammad.green.data.PreferenceHelper.set
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.response.User
import com.muhammad.green.data.network.response.UserLogin
import net.simplifiedcoding.data.UserPreferences

class AuthRepository(private val api: AuthApi, private val preferences: SharedPreferences) : BaseRepository(api){

    suspend fun login(
        userLogin: UserLogin
    ) = safeApiCall {
        api.login(userLogin)
    }

//    suspend fun saveAuthToken(token: String){
//        preferences.saveAccessTokens(token)
//    }


    fun saveToken(token: String){
        preferences["token"] = token
    }

    fun saveUser(user: String){
        preferences["user"] = user
    }

    fun getUser(): String {
        return preferences["user"]
    }


}