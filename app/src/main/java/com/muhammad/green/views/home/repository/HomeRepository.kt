package com.muhammad.green.views.home.repository

import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.HomeApi
import com.muhammad.green.data.network.safeApiCall

class HomeRepository(private val api: HomeApi) : BaseRepository(api) {

    suspend fun getMyCases() = safeApiCall {
            api.getMyCases()
        }

    suspend fun getVisitorHomeData() = safeApiCall {
        api.visitorHomeData()
    }
}