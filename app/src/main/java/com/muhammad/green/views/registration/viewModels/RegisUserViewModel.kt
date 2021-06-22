package com.muhammad.green.views.registration.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.response.RegisUser
import com.muhammad.green.views.registration.response.RegisUserInputs
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.views.registration.response.Governments
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisUserViewModel(private val repository: AuthRepository) :ViewModel() {

    private val _regisResponse = MutableLiveData<ResultWrapper<RegisUser>>()
    val regisResponse: LiveData<ResultWrapper<RegisUser>>
        get() = _regisResponse

    private val _governments = MutableStateFlow<ResultWrapper<Governments>>(ResultWrapper.Loading)
    val governments: StateFlow<ResultWrapper<Governments>>
        get() = _governments

    fun registerVol(
        inputs: RegisUserInputs
    ) = viewModelScope.launch {
        _regisResponse.value = repository.registerVolUser(inputs)
    }

    fun registerNeed(
        inputs: RegisUserInputs
    ) = viewModelScope.launch {
        _regisResponse.value = repository.registerVolUser(inputs)
    }

    fun saveToken(token: String){
        repository.saveToken(token)
    }

    fun getGovernments() = viewModelScope.launch {
        _governments.value = repository.governments()
    }

    private val _navigate = MutableLiveData<Boolean>()
    val navigate: LiveData<Boolean>
        get() = _navigate

    fun navigate(state: Boolean){
        _navigate.value = state
        _navigate.value = false
    }
}