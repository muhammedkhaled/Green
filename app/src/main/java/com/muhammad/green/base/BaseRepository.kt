package com.muhammad.green.base

import com.muhammad.green.views.registration.repository.safeApiCall

abstract class BaseRepository (private val api: BaseApi) {

    suspend fun logout() = safeApiCall {
        api.logout()
    }

}