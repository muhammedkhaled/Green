package net.Aqua_waterfliter.joborder.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.muhammad.green.base.BaseRepository
import com.muhammad.green.data.repository.AuthRepository
import com.muhammad.green.views.registration.viewModels.LoginViewModel


import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}