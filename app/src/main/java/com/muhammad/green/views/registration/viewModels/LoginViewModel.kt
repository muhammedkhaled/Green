package com.muhammad.green.views.registration.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.data.repository.AuthRepository
import com.muhammad.green.data.network.response.LoginSuccess
import com.muhammad.green.data.network.response.UserLogin
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginResponse = MutableLiveData<ResultWrapper<LoginSuccess>>()
    val loginResponse:  LiveData<ResultWrapper<LoginSuccess>>
        get() = _loginResponse


    fun login(
        password: String,
        phone: String
    ) = viewModelScope.launch {
        _loginResponse.value = ResultWrapper.Loading
        _loginResponse.value = repository.login(phone, password)
    }

    fun login(
        userLogin: UserLogin
    ) = viewModelScope.launch {
        _loginResponse.value = ResultWrapper.Loading
        _loginResponse.value = repository.login(userLogin)
    }
}