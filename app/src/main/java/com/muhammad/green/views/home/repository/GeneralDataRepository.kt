package com.muhammad.green.views.home.repository

import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.GeneralDataApi
import com.muhammad.green.data.network.safeApiCall

class GeneralDataRepository(private val api: GeneralDataApi) : BaseRepository(api) {

    suspend fun getManagementWord() = safeApiCall {
        api.getManagementWord()
    }

    suspend fun getAboutUs() = safeApiCall {
        api.getAboutUs()
    }

    suspend fun getContactUs() = safeApiCall {
        api.getContactUs()
    }

    suspend fun getNotifications() = safeApiCall {
        api.getNotifications()
    }
}