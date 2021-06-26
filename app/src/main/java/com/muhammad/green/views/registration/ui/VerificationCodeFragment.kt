package com.muhammad.green.views.registration.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.muhammad.green.data.network.AuthApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.RegisVerificationCodeFragmentBinding
import com.muhammad.green.views.home.ui.MainActivity
import com.muhammad.green.views.registration.repository.SmsVerifyRepository
import com.muhammad.green.views.registration.viewModels.SmsVerifyViewModel
import com.muhammad.green.views.ViewModelFactory
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.enable
import net.Aqua_waterfliter.joborder.utiles.handleApiError
import net.Aqua_waterfliter.joborder.utiles.startNewActivity
import net.Aqua_waterfliter.joborder.utiles.visible


class VerificationCodeFragment : BaseFragment<RegisVerificationCodeFragmentBinding>() {
    private lateinit var viewModel: SmsVerifyViewModel

    private var phone = ""
    private var code = ""

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisVerificationCodeFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()
        val arguments = VerificationCodeFragmentArgs.fromBundle(requireArguments())
        phone = arguments.phone
        viewModel.navigate.observe(viewLifecycleOwner){
            if (it == true) {
                requireActivity().startNewActivity(MainActivity::class.java)
            }
        }
        binding.sendBtn.setOnClickListener{
            code = binding.otpViewCode.text.toString()
            val map = mapOf<String, String>(
                "verify_code" to code,
                "phone" to phone
            )

            viewModel.verify(map)
        }

        binding.otpViewCode.requestFocus()

        binding.otpViewCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                binding.sendBtn.isEnabled = s.toString().length == 4
                code = s.toString()
            }
        })

        setResendTimer()
        binding.resendCodeTv.setOnClickListener {
            // todo call resend verification code from viewModel
            setResendTimer()
        }
        observe()
    }

    private fun setResendTimer(){
        binding.resendCodeTv.enable(false)
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.resendCodeTv.text =  "اعاده ارسال كود التفعيل بعد " + " ${millisUntilFinished / 1000} ثوان  "
            }

            override fun onFinish() {
                binding.resendCodeTv.text = "ارسال كود التفعيل!"
                binding.resendCodeTv.enable(false)
            }
        }.start()
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(AuthApi::class.java)
        val repository = SmsVerifyRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(SmsVerifyViewModel::class.java)
    }

    private fun observe(){
        viewModel.verify.observe(viewLifecycleOwner){
            when(it){
                is ResultWrapper.Loading -> {
                    binding.progressbar.visible(true)
                    binding.sendBtn.enable(false)
                }
                is ResultWrapper.Success -> {
                    binding.progressbar.visible(false)
                    binding.sendBtn.enable(true)
                    viewModel.navigate(true)
                }
                is ResultWrapper.GenericError -> {
                    binding.progressbar.visible(false)
                    binding.sendBtn.enable(true)
                    handleApiError(it)
                }

            }
        }
    }

}