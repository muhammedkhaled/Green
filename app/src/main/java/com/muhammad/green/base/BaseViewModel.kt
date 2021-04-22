package net.Aqua_waterfliter.joborder.base

import androidx.lifecycle.ViewModel
import com.muhammad.green.base.BaseRepository


abstract class BaseViewModel(
    private val repository: BaseRepository
) : ViewModel() {

//    suspend fun logout(api: DataApi) = withContext(Dispatchers.IO) { repository.logout(api) }
}