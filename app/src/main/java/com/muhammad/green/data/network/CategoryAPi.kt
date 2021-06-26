package com.muhammad.green.data.network

import com.muhammad.green.base.BaseApi
import com.muhammad.green.views.home.response.CategoryDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryAPi : BaseApi {

    @GET("category/show-sub")
    suspend fun getSubCategories(@Query("sub_category_id") sub_category_id: Int): CategoryDetails

    @GET("category/show-sub-sub")
    suspend fun getSubCategoryCases(@Query("sub_sub_category_id") sub_sub_category_id: Int): CategoryDetails

}