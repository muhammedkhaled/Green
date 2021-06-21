package com.muhammad.green.views.home.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.databinding.FragmentEditeMyInfoBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment
import com.muhammad.green.data.PreferenceHelper.get
import com.muhammad.green.data.PreferenceHelper.set
import com.muhammad.green.views.home.response.User

class EditeMyInfoFragment : BaseFragment<FragmentEditeMyInfoBinding>() {
    private lateinit var pref: SharedPreferences

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEditeMyInfoBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = PreferenceHelper.customPrefs(requireContext(), "green")
        bindData()
    }

    private fun bindData() {
        val gson = Gson()
        val userString: String = pref["user_profile"]
        val user: User? = gson.fromJson(userString, User::class.java)
        user?.let {
            binding.fullNameTv.text = it.name
            binding.addressTv.text = it.address
            binding.emailTv.text = it.email
        }

    }

}