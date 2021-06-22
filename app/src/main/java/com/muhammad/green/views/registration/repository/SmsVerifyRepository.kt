package com.muhammad.green.views.registration.repository

import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.safeApiCall

class SmsVerifyRepository(private val api: AuthApi) : BaseRepository(api) {

    suspend fun verify(verify: Map<String, String>) = safeApiCall {
        api.verify(verify)
    }
}