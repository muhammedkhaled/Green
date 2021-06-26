package com.muhammad.green.views.home.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.network.GeneralDataApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.FragmentNotificationBinding
import com.muhammad.green.views.home.adapters.NotificationAdapter
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.viewModels.NotificationViewModel
import com.muhammad.green.views.ViewModelFactory
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.visible


class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    private lateinit var viewModel: NotificationViewModel
    private lateinit var pref: SharedPreferences
    private lateinit var adapter: NotificationAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = PreferenceHelper.customPrefs(requireContext(), "green")

        val manager1 = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.NotificationRv.layoutManager = manager1

        adapter = NotificationAdapter(arrayListOf()){

        }

        binding.NotificationRv.adapter = adapter

        setHasOptionsMenu(true)

        setUpViewModel()
        binding.loadingProgress.visible(true)
        viewModel.getNotifications()
        observeData()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNotificationBinding.inflate(inflater, container, false)

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }

    private fun setUpViewModel() {
//        val token: String = pref["token"]
        val token = "W81E7BgN7sNhCT2Zw5JavmVrN0Euns8lKjAnrjpULtmwgVrJKLodMhkniH41"
        val remoteDataSource = RemoteDataSource.buildApi(GeneralDataApi::class.java, token)
        val repository = GeneralDataRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(NotificationViewModel::class.java)
    }

    private fun observeData(){
        lifecycleScope.launchWhenCreated {
            viewModel.notifications.collect {
                binding.loadingProgress.visible(true)
                when(it){
                    is ResultWrapper.Loading -> {
                        binding.loadingProgress.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        binding.loadingProgress.visible(false)
                        adapter.addData(it.value.data)
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgress.visible(false)

                    }
                }
            }
        }

    }
}