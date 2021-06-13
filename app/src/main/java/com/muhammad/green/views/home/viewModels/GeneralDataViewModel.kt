package com.muhammad.green.views.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.response.AboutUs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GeneralDataViewModel(private val repository: GeneralDataRepository) : ViewModel() {

    private val _managementWord = MutableStateFlow<ResultWrapper<AboutUs>>(ResultWrapper.Loading)
    val managementWord = _managementWord.asStateFlow()
    fun getManagementWord() {
        viewModelScope.launch {
            _managementWord.value = repository.getManagementWord()
        }
    }

    private val _aboutUs = MutableStateFlow<ResultWrapper<AboutUs>>(ResultWrapper.Loading)
    val aboutUs = _aboutUs.asStateFlow()
    fun getAboutUs() {
        viewModelScope.launch {
            _aboutUs.value = repository.getAboutUs()
        }
    }

    private val _contactUs = MutableStateFlow<ResultWrapper<AboutUs>>(ResultWrapper.Loading)
    val contactUs = _contactUs.asStateFlow()
    fun getContactUs() {
        viewModelScope.launch {
            _contactUs.value = repository.getContactUs()
        }
    }

}