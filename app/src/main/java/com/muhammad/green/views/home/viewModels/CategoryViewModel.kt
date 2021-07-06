package com.muhammad.green.views.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.home.repository.CategoryRepository
import com.muhammad.green.views.home.response.AboutUs
import com.muhammad.green.views.home.response.CategoryCases
import com.muhammad.green.views.home.response.CategoryDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoryViewModel(private val repository: CategoryRepository) : ViewModel() {

    private val _subCategories = MutableStateFlow<ResultWrapper<CategoryDetails>>(ResultWrapper.Loading)
    val subCategories = _subCategories.asStateFlow()
    fun getSubCategories(categoryId: Int) {
        viewModelScope.launch {
            _subCategories.value = repository.getSubCategories(categoryId)
        }
    }

    private val _subCategoryCases = MutableStateFlow<ResultWrapper<CategoryCases>>(ResultWrapper.Loading)
    val subCategoryCases = _subCategoryCases.asStateFlow()
    fun getSubCategoryCases(categoryId: Int) {
        viewModelScope.launch {
            _subCategoryCases.value = repository.getSubCategoryCases(categoryId)
        }
    }
}