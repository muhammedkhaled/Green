package com.muhammad.green.views.home.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.response.Notifications
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NotificationViewModel(private val repository: GeneralDataRepository) : ViewModel() {

    private val _notifications = MutableStateFlow<ResultWrapper<Notifications>>(ResultWrapper.Loading)
    val notifications = _notifications.asStateFlow()

    fun getNotifications(){
        viewModelScope.launch {
            _notifications.value = repository.getNotifications()
        }
    }
}