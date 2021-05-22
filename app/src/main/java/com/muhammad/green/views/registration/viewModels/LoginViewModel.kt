package com.muhammad.green.views.registration.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.data.repository.AuthRepository
import com.muhammad.green.data.network.response.LoginSuccess
import com.muhammad.green.data.network.response.User
import com.muhammad.green.data.network.response.UserLogin
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginResponse = MutableLiveData<ResultWrapper<LoginSuccess>>()
    val loginResponse:  LiveData<ResultWrapper<LoginSuccess>>
        get() = _loginResponse

//    private val _user= MutableLiveData<User>()
//    val user: LiveData<User>
//        get() = _user

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
        val encodedUser = Json.encodeToString(user)
//        repository.saveUser(encodedUser)
    }

//    fun getSavedUser(){
//        _user.value = Json.decodeFromString<User>(repository.getUser())
//    }
}