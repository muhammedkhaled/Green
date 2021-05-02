package com.muhammad.green.ui.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.databinding.FragmentCaseDetailsBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class CaseDetailsFragment : BaseFragment<FragmentCaseDetailsBinding>() {


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCaseDetailsBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.caseReportsBtn.setOnClickListener {
            findNavController().navigate(
                CaseDetailsFragmentDirections.actionCaseDetailsFragmentToCaseReportsFragment()
            )
        }
    }

}