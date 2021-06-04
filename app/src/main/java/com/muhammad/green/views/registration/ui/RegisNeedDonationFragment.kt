package com.muhammad.green.views.registration.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
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
import com.muhammad.green.views.registration.response.Data
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
    private var governmentID = ""

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

        binding.regisVolGovActv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, pos, _ ->
                val index = parent.getItemAtPosition(pos) as Data
                governmentID = index.id.toString()
                Log.d("TAG", "onViewCreated: ${index.id}")
            }
    }

    private fun register() {
        val name = binding.regisVolNameEt.text.trim()
        val phone = binding.regisVolPhoneEt.text.trim()
//        val city
//        val lat
//        val long
        val pass = binding.regisVolPassEt.text.trim()
        val conditions = binding.conditionsCheckbox.isChecked

        when {
            name.isEmpty() -> {
                binding.regisVolNameEt.error = "برجاء كتابه الاسم"
                binding.regisVolNameEt.requestFocus()
            }
            phone.isEmpty() -> {
                binding.regisVolPhoneEt.error = "برجاء كتابه رقم تليفون"
                binding.regisVolPhoneEt.requestFocus()
            }
            phone.length != 11 -> {
                binding.regisVolPhoneEt.error = "برجاء كتابه رقم تليفون صالح"
                binding.regisVolPhoneEt.requestFocus()
            }
            governmentID.isEmpty() -> {
                binding.regisVolGovActv.error = "برجاء اختيار المحافظه"
                binding.regisVolGovActv.requestFocus()
            }
            pass.isEmpty() -> {
                binding.regisVolPassEt.error = "بؤجاء ادخال كلمه السر"
                binding.regisVolPassEt.requestFocus()
            }
            pass.length <= 6 -> {
                binding.regisVolPassEt.error = "برجاء ادخال كلمه سر اكبر من 6 ارقام"
                binding.regisVolPassEt.requestFocus()
            }
            !conditions -> {
                Toast.makeText(requireContext(), "لابد من الموافقه على شروط التسجيل", Toast.LENGTH_SHORT).show()
            }

        }

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