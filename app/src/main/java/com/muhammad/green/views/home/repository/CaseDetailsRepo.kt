package com.muhammad.green.views.home.repository

import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.CaseDetailsApi
import com.muhammad.green.data.network.CategoryAPi
import com.muhammad.green.data.network.safeApiCall
import com.muhammad.green.views.home.response.CategoryDetails
import retrofit2.http.GET
import retrofit2.http.Query

class CaseDetailsRepo(private val api: CaseDetailsApi) : BaseRepository(api) {

    suspend fun getCaseInfo(categoryId: Int) = safeApiCall {
        api.getCaseInfo(categoryId)
    }
}