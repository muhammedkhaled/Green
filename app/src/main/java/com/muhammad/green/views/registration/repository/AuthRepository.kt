package com.muhammad.green.views.registration.repository

import android.content.SharedPreferences
import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.PreferenceHelper.get
import com.muhammad.green.data.PreferenceHelper.set
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.views.registration.response.RegisUserInputs
import com.muhammad.green.views.registration.response.UserLogin

class AuthRepository(private val api: AuthApi, private val preferences: SharedPreferences) : BaseRepository(api){

    suspend fun login(
        userLogin: UserLogin
    ) = safeApiCall {
        api.login(userLogin)
    }

    suspend fun registerVolUser(
        inputs: RegisUserInputs
    ) = safeApiCall {
        api.RegisVolUser(inputs)
    }

    suspend fun registerNeedUser(
        inputs: RegisUserInputs
    ) = safeApiCall {
        api.RegisNeedUser(inputs)
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