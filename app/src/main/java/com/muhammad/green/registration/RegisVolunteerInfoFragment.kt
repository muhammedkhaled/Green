package com.muhammad.green.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.R
import com.muhammad.green.databinding.RegisVolunteerInfoFragmnetBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class RegisVolunteerInfoFragment : BaseFragment<RegisVolunteerInfoFragmnetBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisVolunteerInfoFragmnetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.regisVolNextBtn.setOnClickListener{
            findNavController().navigate(
                RegisVolunteerInfoFragmentDirections
                    .actionRegisVolunteerInfoFragmnetToVerificationCodeFragment()
            )
        }
    }

}