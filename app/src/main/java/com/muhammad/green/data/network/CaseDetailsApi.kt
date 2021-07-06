package com.muhammad.green.data.network

import com.muhammad.green.base.BaseApi
import com.muhammad.green.views.home.response.CaseFullData
import com.muhammad.green.views.home.response.CategoryDetails
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CaseDetailsApi : BaseApi {

    @GET("account")
    suspend fun getCaseInfo(@Query("id") caseID: Int): CaseFullData

}