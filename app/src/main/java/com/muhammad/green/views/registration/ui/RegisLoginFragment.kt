package com.muhammad.green.views.registration.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.views.registration.response.User
import com.muhammad.green.views.registration.repository.AuthRepository
import com.muhammad.green.views.registration.response.UserLogin
import com.muhammad.green.databinding.RegisLoginFragmentBinding
import com.muhammad.green.views.registration.viewModels.LoginViewModel
import net.Aqua_waterfliter.joborder.base.BaseFragment
import com.muhammad.green.views.registration.viewModels.ViewModelFactory
import net.Aqua_waterfliter.joborder.utiles.enable
import net.Aqua_waterfliter.joborder.utiles.handleApiError
import net.Aqua_waterfliter.joborder.utiles.visible


class RegisLoginFragment : BaseFragment<RegisLoginFragmentBinding>() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var pref: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loadingProgress.visible(false)
        binding.loginBtn.enable(true)
        setUpViewModel()

        binding.loginBtn.setOnClickListener {
            login()
        }

        binding.signInTv.setOnClickListener {
            findNavController().navigate(
                RegisLoginFragmentDirections.actionRegisLoginFragmentToRegisUserTypeFragment()
            )
        }

        loginViewModel.loginResponse.observe(viewLifecycleOwner) {
            binding.loadingProgress.visible(it is ResultWrapper.Loading)
            when (it) {
                is ResultWrapper.Success -> {
                    loginViewModel.saveToken(it.value.token)
                    val user: User = it.value.user
                    loginViewModel.saveUserInfo(user)

                    Log.d("token", "onViewCreated: ${it.value.token}")
                    Log.d("token", "onViewCreated: $user")
//                        requireActivity().startNewActivity(MainActivity::class.java)
                }
                is ResultWrapper.GenericError -> handleApiError(it) { login() }
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
                // Todo pass mPhone and mPass
                val user = UserLogin("01090645887", "123456")
                loginViewModel.login(user)
            }
        }
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(AuthApi::class.java)
        pref = PreferenceHelper.customPrefs(requireContext(), "regis")
        val repository = AuthRepository(remoteDataSource, pref)
        val factory = ViewModelFactory(repository)
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisLoginFragmentBinding.inflate(inflater, container, false)

}