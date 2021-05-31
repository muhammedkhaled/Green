package com.muhammad.green.views.registration.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.response.RegisUserInputs
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.databinding.RegisVolunteerInfoFragmnetBinding
import com.muhammad.green.views.registration.viewModels.RegisUserViewModel
import com.muhammad.green.views.registration.viewModels.ViewModelFactory
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.handleApiError
import net.Aqua_waterfliter.joborder.utiles.visible

class RegisVolunteerInfoFragment : BaseFragment<RegisVolunteerInfoFragmnetBinding>() {

    private lateinit var viewModel: RegisUserViewModel
    private lateinit var pref: SharedPreferences

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisVolunteerInfoFragmnetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        binding.regisVolNextBtn.setOnClickListener{
//            findNavController().navigate(
//                RegisVolunteerInfoFragmentDirections
//                    .actionRegisVolunteerInfoFragmnetToVerificationCodeFragment()
//            )
            register()
        }

        viewModel.regisResponse.observe(viewLifecycleOwner){
            binding.progressbar.visible(it is ResultWrapper.Loading)
            when (it) {
                is ResultWrapper.Success -> {
                    it.value.token?.let {
                        viewModel.saveToken(it)
                    }

                    Log.d("token", "onViewCreated: ${it.value.token}")
                }
                is ResultWrapper.GenericError -> handleApiError(it) { register() }
            }
        }
    }

    private fun register() {
        val inputs = RegisUserInputs("muhamed", "01125889197", "11 abdallah hendy", "muhamed@gmail.com","0125cairo"
        ,"cairo", "1","0125cairo", "-33.863276", "151.207977")
        viewModel.registerVol(inputs)
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(AuthApi::class.java)
        pref = PreferenceHelper.customPrefs(requireContext(), "regis")
        val repository = AuthRepository(remoteDataSource, pref)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(RegisUserViewModel::class.java)
    }

}