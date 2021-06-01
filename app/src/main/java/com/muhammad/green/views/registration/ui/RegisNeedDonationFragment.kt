package com.muhammad.green.views.registration.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.muhammad.green.R
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.response.RegisUserInputs
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.databinding.RegisNeedDonationFragmnetBinding
import com.muhammad.green.views.registration.response.Governments
import com.muhammad.green.views.registration.viewModels.RegisUserViewModel
import com.muhammad.green.views.registration.viewModels.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.handleApiError
import net.Aqua_waterfliter.joborder.utiles.visible

class RegisNeedDonationFragment : BaseFragment<RegisNeedDonationFragmnetBinding>() {

    private lateinit var viewModel: RegisUserViewModel
    private lateinit var pref: SharedPreferences

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisNeedDonationFragmnetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        viewModel.getGovernments()

        lifecycleScope.launch {
            viewModel.governments.collect {
                when(it){
                    is ResultWrapper.Success -> {
                        initSpinners(it.value)
                        Log.d("RegisNeed", "governments: ${it.value}")
                    }
                }
            }
        }

        binding.regisVolNextBtn.setOnClickListener{
//            findNavController().navigate(
//                RegisNeedDonationFragmentDirections
//                    .actionRegisNeedDonationFragmentToVerificationCodeFragment()
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

    fun initSpinners(governments: Governments){
        binding.regisVolGovActv.setAdapter(
            ArrayAdapter(requireContext(), R.layout.auto_complete_text_view, governments.data)
        )
    }
}