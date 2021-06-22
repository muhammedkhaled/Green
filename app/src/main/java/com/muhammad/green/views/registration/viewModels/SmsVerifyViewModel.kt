package com.muhammad.green.views.registration.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.repository.SmsVerifyRepository
import com.muhammad.green.views.registration.response.SmsMsg
import kotlinx.coroutines.launch

class SmsVerifyViewModel(private val repository: SmsVerifyRepository): ViewModel() {

    private val _verify = MutableLiveData<ResultWrapper<SmsMsg>>()
    val verify: LiveData<ResultWrapper<SmsMsg>>
        get() = _verify

    fun verify(
        verifyMap: Map<String, String>
    ) = viewModelScope.launch {
        _verify.value = repository.verify(verifyMap)
    }

    private val _navigate = MutableLiveData<Boolean>()
    val navigate: LiveData<Boolean>
        get() = _navigate

    fun navigate(state: Boolean){
        _navigate.value = state
        _navigate.value = false
    }
}