package com.muhammad.green.views.registration.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.muhammad.green.R
import com.muhammad.green.databinding.RegisUserTypeFragmnetBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class RegisUserTypeFragment : BaseFragment<RegisUserTypeFragmnetBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = RegisUserTypeFragmnetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.check)
        binding.volunteerBtn.setOnClickListener{
            binding.volunteerBtn.icon = drawable
            findNavController().navigate(
                RegisUserTypeFragmentDirections
                    .actionRegisUserTypeFragmentToRegisVolunteerInfoFragmnet()
            )
        }

        binding.worthDonationBtn.setOnClickListener{
            binding.volunteerBtn.icon = drawable
            findNavController().navigate(
                RegisUserTypeFragmentDirections
                    .actionRegisUserTypeFragmentToRegisNeedDonationFragment()
            )
        }
    }

}