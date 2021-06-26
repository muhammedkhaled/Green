package com.muhammad.green.views.home.repository

import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.network.CategoryAPi
import com.muhammad.green.data.network.safeApiCall

class CategoryRepository(private val api: CategoryAPi) : BaseRepository(api) {

    suspend fun getSubCategories(categoryId: Int) = safeApiCall {
        api.getSubCategories(categoryId)
    }

    suspend fun getSubCategoryCases(categoryId: Int) = safeApiCall {
        api.getSubCategoryCases(categoryId)
    }
}