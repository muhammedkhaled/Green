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
import androidx.navigation.fragment.findNavController
import com.muhammad.green.R
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.RegisVolunteerInfoFragmnetBinding
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.views.registration.response.Cities
import com.muhammad.green.views.registration.response.Data
import com.muhammad.green.views.registration.response.Governments
import com.muhammad.green.views.registration.response.RegisUserInputs
import com.muhammad.green.views.registration.viewModels.RegisUserViewModel
import com.muhammad.green.views.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.handleApiError
import net.Aqua_waterfliter.joborder.utiles.visible


class RegisVolunteerInfoFragment : BaseFragment<RegisVolunteerInfoFragmnetBinding>() {

    private lateinit var viewModel: RegisUserViewModel
    private lateinit var pref: SharedPreferences
    private var governmentID = ""
    private var cityID = ""
    private var phone = ""

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisVolunteerInfoFragmnetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        viewModel.getGovernments()

        viewModel.navigate.observe(viewLifecycleOwner){
            if (it == true) {
                findNavController().navigate(
                    RegisVolunteerInfoFragmentDirections
                        .actionRegisVolunteerInfoFragmnetToVerificationCodeFragment(phone)
                )
                viewModel.navigate(false)
            }
        }

        lifecycleScope.launch {
            viewModel.governments.collect {
                when (it){
                    is ResultWrapper.Success -> {
                        initSpinners(it.value)
                        Log.d("RegisNeed", "governments: ${it.value}")
                    }
                    is ResultWrapper.GenericError -> handleApiError(it)
                }
            }
        }
        binding.regisVolNextBtn.setOnClickListener{
            register()
        }

        viewModel.regisResponse.observe(viewLifecycleOwner){
            binding.progressbar.visible(it is ResultWrapper.Loading)
            when (it) {
                is ResultWrapper.Success -> {
                    it.value.token?.let { it ->
                        viewModel.saveToken(it)
                    }
                    viewModel.navigate(true)
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

        binding.regisVolCityActv.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, pos, _ ->
                val index = parent.getItemAtPosition(pos) as Cities
                cityID = index.id.toString()
                Log.d("TAG", "onViewCreated: ${index.id}")
            }

       binding.regisVolLocationBtn.setOnClickListener {
            findNavController().navigate(
                RegisVolunteerInfoFragmentDirections
                    .actionRegisVolunteerInfoFragmnetToMapsFragment()
            )
        }

    }

    private fun register() {
        val name = binding.regisVolNameEt.text.trim().toString()
        phone = binding.regisVolPhoneEt.text.trim().toString()
        var lat = UserData.lat.trim()
        var long = UserData.long.trim()
        val pass = binding.regisVolPassEt.text.trim().toString()
        val conditions = binding.conditionsCheckbox.isChecked
        val address = binding.addressEt.text.trim().toString()
        val email = binding.emailEt.text.trim().toString()

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
            email.isEmpty() -> {
                // todo validate the email skema
                binding.emailEt.error = "برجاء كتابه البريد الاكترونى"
                binding.emailEt.requestFocus()
            }
            governmentID.isEmpty() -> {
                binding.regisVolGovActv.error = "برجاء اختيار المحافظه"
                binding.regisVolGovActv.requestFocus()
            }
            cityID.isEmpty() -> {
                binding.regisVolGovActv.error = "برجاء اختيار المدينه"
                binding.regisVolGovActv.requestFocus()
            }
            pass.isEmpty() -> {
                binding.regisVolPassEt.error = "برجاء ادخال كلمه السر"
                binding.regisVolPassEt.requestFocus()
            }
            pass.length <= 6 -> {
                binding.regisVolPassEt.error = "برجاء ادخال كلمه سر اكبر من 6 ارقام"
                binding.regisVolPassEt.requestFocus()
            }
            address.isEmpty() -> {
                binding.addressEt.error = "برجاء ادخال العنوان"
                binding.addressEt.requestFocus()
            }
            !conditions -> {
                Toast.makeText(
                    requireContext(),
                    "لابد من الموافقه على شروط التسجيل",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                val inputs = RegisUserInputs( name, phone, address, email,pass
                    ,cityID, governmentID,pass, long, lat)
                Log.d("TAG", "register: $inputs")
                viewModel.registerVol(inputs)
            }
        }
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(AuthApi::class.java)
        pref = PreferenceHelper.customPrefs(requireContext(), "regis")
        val repository = AuthRepository(remoteDataSource, pref)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(RegisUserViewModel::class.java)
    }

    private fun initSpinners(governments: Governments){
        binding.regisVolGovActv.setAdapter(
            ArrayAdapter(requireContext(), R.layout.auto_complete_text_view, governments.data)
        )

        binding.regisVolCityActv.setAdapter(
            ArrayAdapter(requireContext(), R.layout.auto_complete_text_view, governments.cities)
        )
    }
}