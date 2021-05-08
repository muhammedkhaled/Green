package com.muhammad.green.views.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.R
import com.muhammad.green.databinding.FragmentMenuBinding
import com.muhammad.green.views.landing.ui.LandingActivity
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.startNewActivity

class MenuFragment : BaseFragment<FragmentMenuBinding>() {


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMenuBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        binding.menuMyInfoTv.setOnClickListener{
            findNavController().navigate(
                MenuFragmentDirections.actionNavigationMenuToEditeMyInfoFragment()
            )
        }

        binding.menuNeedMoneyTv.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionNavigationMenuToNewInfoDonationNeedFragment()
            )
        }

        binding.menuMyOrdersTv.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionNavigationMenuToMyNeedsFragment()
            )
        }

        binding.menuAboutUsTv.setOnClickListener{
            findNavController().navigate(
                MenuFragmentDirections.actionNavigationMenuToAboutUsFragment()
            )
        }

        binding.menuAdminWordTv.setOnClickListener{
            findNavController().navigate(
                MenuFragmentDirections.actionNavigationMenuToAdministrationWordFragment()
            )
        }

        binding.menuLogoutTv.setOnClickListener {
            requireActivity().startNewActivity(LandingActivity::class.java)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }

}