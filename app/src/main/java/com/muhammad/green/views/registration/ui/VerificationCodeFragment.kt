package com.muhammad.green.views.registration.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muhammad.green.databinding.RegisVerificationCodeFragmentBinding
import com.muhammad.green.views.home.ui.MainActivity
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.enable
import net.Aqua_waterfliter.joborder.utiles.startNewActivity


class VerificationCodeFragment : BaseFragment<RegisVerificationCodeFragmentBinding>() {


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisVerificationCodeFragmentBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener{
            requireActivity().startNewActivity(MainActivity::class.java)
        }

        binding.otpViewCode.requestFocus()

        binding.otpViewCode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                binding.loginBtn.isEnabled = s.toString().length == 4
            }
        })


        setResendTimer()
        binding.resendCodeTv.setOnClickListener {
            // todo call resend verification code from viewModel
            setResendTimer()
        }
    }


    private fun setResendTimer(){
        binding.resendCodeTv.enable(false)
        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.resendCodeTv.text = " ثانيه${millisUntilFinished / 1000}اعاده ارسال كود التفعيل بعد: "
            }

            override fun onFinish() {
                binding.resendCodeTv.text = "ارسال كود التفعيل!"
                binding.resendCodeTv.enable(false)
            }
        }.start()
    }
}