package com.muhammad.green.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.R
import com.muhammad.green.databinding.RegisVerificationCodeFragmentBinding
import com.muhammad.green.home.MainActivity
import net.Aqua_waterfliter.joborder.base.BaseFragment
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
    }
}