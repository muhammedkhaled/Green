package com.muhammad.green.views.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.muhammad.green.R
import com.muhammad.green.data.network.GeneralDataApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.FragmentCallUsBinding
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.response.Data
import com.muhammad.green.views.home.viewModels.GeneralDataViewModel
import com.muhammad.green.views.ViewModelFactory
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.visible

class CallUsFragment : BaseFragment<FragmentCallUsBinding>() {
    private lateinit var viewModel: GeneralDataViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setUpViewModel()
        // todo need to fill layout with data
        binding.loadingProgress.visible(true)
        viewModel.getContactUs()
        observeData()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCallUsBinding.inflate(inflater, container, false)

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(GeneralDataApi::class.java)
        val repository = GeneralDataRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(GeneralDataViewModel::class.java)
    }

    private fun observeData(){
        lifecycleScope.launchWhenCreated {
            viewModel.contactUs.collect {
                when(it){
                    is ResultWrapper.Loading -> {
                        binding.loadingProgress.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        binding.loadingProgress.visible(false)
                        bindData(it.value.data)
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgress.visible(false)
                    }
                }
            }
        }

    }

    private fun bindData(data: Data) {

    }
}