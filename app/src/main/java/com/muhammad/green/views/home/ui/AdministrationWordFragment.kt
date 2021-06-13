package com.muhammad.green.views.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muhammad.green.R
import com.muhammad.green.data.network.GeneralDataApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.FragmentAdministrationWordBinding
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.response.Data
import com.muhammad.green.views.home.viewModels.GeneralDataViewModel
import com.muhammad.green.views.registration.viewModels.ViewModelFactory
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.visible

class AdministrationWordFragment : BaseFragment<FragmentAdministrationWordBinding>() {
    private lateinit var viewModel: GeneralDataViewModel

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentAdministrationWordBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        binding.loadingProgress.visible(true)
        viewModel.getManagementWord()
        observeData()
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(GeneralDataApi::class.java)
        val repository = GeneralDataRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(GeneralDataViewModel::class.java)
    }

    private fun observeData(){
        lifecycleScope.launchWhenCreated {
            viewModel.managementWord.collect {
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
        binding.adminWordTv.text = data.body
        binding.AdminInstructionsTitle.text = data.title
        Glide.with(requireContext())
            .load(data.photo)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.landing1)
                    .error(R.drawable.landing1))
            .into(binding.shapeableImageView)
    }

}