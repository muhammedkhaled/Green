package com.muhammad.green.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.databinding.FragmentVolInKindDonationsBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class VolInKindDonationsFragment : BaseFragment<FragmentVolInKindDonationsBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentVolInKindDonationsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.DonateNewDeviceBtn.setOnClickListener {
            findNavController().navigate(
                VolInKindDonationsFragmentDirections.actionVolInKindDonationsFragmentToDonateDeviceFragment()
            )
        }
    }


}