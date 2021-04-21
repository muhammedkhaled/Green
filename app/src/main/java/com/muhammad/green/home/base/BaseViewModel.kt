package net.Aqua_waterfliter.joborder.base

import androidx.lifecycle.ViewModel
import com.muhammad.green.home.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {

//    suspend fun logout(api: DataApi) = withContext(Dispatchers.IO) { repository.logout(api) }
}