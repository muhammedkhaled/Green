package com.muhammad.green.views.landing.repository

import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.IntroApi
import com.muhammad.green.data.network.safeApiCall

class IntroRepository(private val api: IntroApi): BaseRepository(api) {

    suspend fun getIntroData() = safeApiCall {
        api.getIntroData()
    }
}