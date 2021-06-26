package com.muhammad.green.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhammad.green.base.BaseRepository
import com.muhammad.green.views.home.repository.CategoryRepository
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.repository.HomeRepository
import com.muhammad.green.views.home.viewModels.CategoryViewModel
import com.muhammad.green.views.home.viewModels.GeneralDataViewModel
import com.muhammad.green.views.home.viewModels.HomeViewModel
import com.muhammad.green.views.home.viewModels.NotificationViewModel
import com.muhammad.green.views.landing.repository.IntroRepository
import com.muhammad.green.views.landing.viewModels.IntroViewModel
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.views.registration.repository.SmsVerifyRepository
import com.muhammad.green.views.registration.viewModels.LoginViewModel
import com.muhammad.green.views.registration.viewModels.RegisUserViewModel
import com.muhammad.green.views.registration.viewModels.SmsVerifyViewModel


import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(RegisUserViewModel::class.java) -> RegisUserViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as HomeRepository) as T
            modelClass.isAssignableFrom(GeneralDataViewModel::class.java) -> GeneralDataViewModel(repository as GeneralDataRepository) as T
            modelClass.isAssignableFrom(IntroViewModel::class.java) -> IntroViewModel(repository as IntroRepository) as T
            modelClass.isAssignableFrom(NotificationViewModel::class.java) -> NotificationViewModel(repository as GeneralDataRepository) as T
            modelClass.isAssignableFrom(SmsVerifyViewModel::class.java) -> SmsVerifyViewModel(repository as SmsVerifyRepository) as T
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> CategoryViewModel(repository as CategoryRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}