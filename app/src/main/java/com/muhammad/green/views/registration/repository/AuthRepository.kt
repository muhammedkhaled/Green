package com.muhammad.green.views.registration.repository

import android.content.SharedPreferences
import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.PreferenceHelper.get
import com.muhammad.green.data.PreferenceHelper.set
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.safeApiCall
import com.muhammad.green.data.network.safeApiCallRegistration
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
    ) = safeApiCallRegistration {
        api.RegisVolUser(inputs)
    }

    suspend fun registerNeedUser(
        inputs: RegisUserInputs
    ) = safeApiCallRegistration {
        api.regisNeedUser(inputs)
    }

    suspend fun governments() = safeApiCall { api.governments() }

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