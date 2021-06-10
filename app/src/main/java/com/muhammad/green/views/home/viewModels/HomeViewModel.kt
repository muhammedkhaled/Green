package com.muhammad.green.views.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.views.home.repository.HomeRepository
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.home.response.MyCases
import com.muhammad.green.views.home.response.VisitorHomeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel(){


    private val _myCases = MutableStateFlow<ResultWrapper<MyCases>>(ResultWrapper.Loading)
    val myCases: StateFlow<ResultWrapper<MyCases>> = _myCases
    fun getMyCases(){
        viewModelScope.launch {
            _myCases.value = repository.getMyCases()
        }
    }

    private val _visitorData = MutableStateFlow<ResultWrapper<VisitorHomeData>>(ResultWrapper.Loading)
    val visitorData = _visitorData.asStateFlow()
    fun getVisitorData() {
        viewModelScope.launch {
            _visitorData.value = repository.getVisitorHomeData()
        }
    }
}