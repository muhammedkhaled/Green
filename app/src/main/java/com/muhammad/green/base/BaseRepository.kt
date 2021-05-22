package com.muhammad.green.base

import android.content.SharedPreferences
import com.muhammad.green.data.PreferenceHelper.set
import com.muhammad.green.data.repository.safeApiCall

abstract class BaseRepository (private val api: BaseApi) {

    suspend fun logout() = safeApiCall {
        api.logout()
    }

}