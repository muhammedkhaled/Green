package com.muhammad.green.views.registration.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.repository.AuthRepository
import com.muhammad.green.data.network.response.UserLogin
import com.muhammad.green.databinding.RegisLoginFragmentBinding
import com.muhammad.green.views.registration.viewModels.LoginViewModel
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.base.ViewModelFactory
import net.Aqua_waterfliter.joborder.utiles.enable
import net.Aqua_waterfliter.joborder.utiles.handleApiError
import net.Aqua_waterfliter.joborder.utiles.visible
import net.simplifiedcoding.data.UserPreferences


class RegisLoginFragment : BaseFragment<RegisLoginFragmentBinding>() {

    private lateinit var loginViewModel: LoginViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loadingProgress.visible(false)
        binding.loginBtn.enable(true)
        setUpViewModel()

        binding.loginBtn.setOnClickListener {
//            loginViewModel.login("123456", "01090645887")

            val userLogin = UserLogin("01090645887", "123456")
            loginViewModel.login(userLogin)
        }

        binding.signInTv.setOnClickListener {
            findNavController().navigate(
                RegisLoginFragmentDirections.actionRegisLoginFragmentToRegisUserTypeFragment()
            )
        }

        lifecycleScope.launchWhenCreated {
            loginViewModel.loginResponse.observe(viewLifecycleOwner) {
                binding.loadingProgress.visible(it is ResultWrapper.Loading)
                when (it) {
                    is ResultWrapper.Success -> {
//                        loginViewModel.saveAuthToken(it.value.access_token)
//                        requireActivity().startNewActivity(MainActivity::class.java)
//                        DynamicData.userName = it.value.userName
//                        DynamicData.token = it.value.access_token
                        Log.d("token", "onViewCreated: ${it.value.token}")
                        Log.d("token", "onViewCreated: ${it.value.user}")
//                        requireActivity().startNewActivity(MainActivity::class.java)

                    }
                    is ResultWrapper.GenericError -> handleApiError(it) { login() }
                }
            }
        }
    }


    private fun login() {
        val mPhone = binding.loginPhoneNumEt.text.toString().trim()
        val mPass = binding.loginPasswordEt.text.toString().trim()

        when {
            mPhone.isEmpty() -> {
                binding.loginPhoneNumEt.error = "برجاء كتابه رقم هاتف صحيح"
                binding.loginPhoneNumEt.requestFocus()
            }
            mPass.isEmpty() -> {
                binding.loginPasswordEt.error = "برجاء كتابه الباسورد"
                binding.loginPasswordEt.requestFocus()
            }
            else -> {
//                viewModel.login("Negm@2017", "admin@admin.com", "password")
                loginViewModel.login("01090645887", "123456")
            }
        }
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(AuthApi::class.java)
        val repository = AuthRepository(remoteDataSource, UserPreferences(requireContext()))
        val factory = ViewModelFactory(repository)
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisLoginFragmentBinding.inflate(inflater, container, false)

}