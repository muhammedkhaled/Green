package com.muhammad.green.views.registration.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.views.registration.response.Governments
import com.muhammad.green.views.registration.response.LoginSuccess
import com.muhammad.green.views.registration.response.User
import com.muhammad.green.views.registration.response.UserLogin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val gson = Gson()

    private val _loginResponse = MutableLiveData<ResultWrapper<LoginSuccess>>()
    val loginResponse:  LiveData<ResultWrapper<LoginSuccess>>
        get() = _loginResponse

    private val _user= MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun login(
        userLogin: UserLogin
    ) = viewModelScope.launch {
        _loginResponse.value = ResultWrapper.Loading
        _loginResponse.value = repository.login(userLogin)
    }

    fun saveToken(token: String){
        repository.saveToken(token)
    }

    fun saveUserInfo(user: User){
        val userString = gson.toJson(user)
        repository.saveUser(userString)
    }

    fun getSavedUser(){
        _user.value = gson.fromJson(repository.getUser(), User::class.java)
    }
}