package com.muhammad.green.home

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.muhammad.green.databinding.FragmentHomeBinding
import com.muhammad.green.home.adapters.CasesTypeAdapter
import com.muhammad.green.home.adapters.homeDonaCasesAdapter
import com.muhammad.green.utiles.CenterZoomLinearLayoutManager
import net.Aqua_waterfliter.joborder.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inKindDonationBtn.setOnClickListener{
            findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToVolInKindDonationsFragment()
            )
        }

        val manager1 = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.casesOfDonationsRv.layoutManager = manager1

        binding.casesOfDonationsRv.adapter = homeDonaCasesAdapter(listOf("1", "2", "3", "4")){
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToCaseDetailsFragment())
        }

        val center = CenterZoomLinearLayoutManager(requireContext())
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.casesTypeRv)
        binding.casesTypeRv.layoutManager = center

        binding.casesTypeRv.adapter = CasesTypeAdapter(listOf("1", "2", "3", "4")){
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToDetailsFragment())
        }

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)


}