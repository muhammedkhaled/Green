package com.muhammad.green.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.databinding.FragmentDonateDeviceBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class DonateDeviceFragment : BaseFragment<FragmentDonateDeviceBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDonateDeviceBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendBtn.setOnClickListener {
            findNavController().navigate(
                DonateDeviceFragmentDirections.actionDonateDeviceFragmentToStateOfOrderFragment()
            )
        }
    }

}