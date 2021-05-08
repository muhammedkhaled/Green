package com.muhammad.green.base

import com.muhammad.green.data.repository.safeApiCall

abstract class BaseRepository (private val api: BaseApi) {

    suspend fun logout() = safeApiCall {
        api.logout()
    }
}