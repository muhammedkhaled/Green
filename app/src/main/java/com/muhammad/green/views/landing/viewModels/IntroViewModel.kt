package com.muhammad.green.views.landing.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.home.response.AboutUs
import com.muhammad.green.views.landing.repository.IntroRepository
import com.muhammad.green.views.landing.response.IntroResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class IntroViewModel(private val repository: IntroRepository) : ViewModel() {

    private val _introData = MutableStateFlow<ResultWrapper<IntroResponse>>(ResultWrapper.Loading)
    val introData = _introData.asStateFlow()
    fun getIntroData() {
        viewModelScope.launch {
            _introData.value = repository.getIntroData()
        }
    }
}