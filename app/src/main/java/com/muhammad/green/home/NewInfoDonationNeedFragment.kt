package com.muhammad.green.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muhammad.green.databinding.FragmentNewInfoDonationNeedBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class NewInfoDonationNeedFragment : BaseFragment<FragmentNewInfoDonationNeedBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewInfoDonationNeedBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendBtn.setOnClickListener {

        }
    }


}