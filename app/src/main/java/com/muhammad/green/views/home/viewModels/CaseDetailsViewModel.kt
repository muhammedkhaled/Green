package com.muhammad.green.views.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.home.repository.CaseDetailsRepo
import com.muhammad.green.views.home.repository.CategoryRepository
import com.muhammad.green.views.home.response.CaseFullData
import com.muhammad.green.views.home.response.CategoryDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CaseDetailsViewModel(private val repository: CaseDetailsRepo) : ViewModel()  {

    private val _caseInfo = MutableStateFlow<ResultWrapper<CaseFullData>>(ResultWrapper.Loading)
    val caseInfo = _caseInfo.asStateFlow()
    fun getCaseInfo(categoryId: Int) {
        viewModelScope.launch {
            _caseInfo.value = repository.getCaseInfo(categoryId)
        }
    }
}