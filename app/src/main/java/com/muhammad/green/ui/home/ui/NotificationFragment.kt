package com.muhammad.green.ui.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.databinding.FragmentNotificationBinding
import com.muhammad.green.ui.home.adapters.NotificationAdapter
import net.Aqua_waterfliter.joborder.base.BaseFragment


class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manager1 = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.NotificationRv.layoutManager = manager1
        binding.NotificationRv.adapter = NotificationAdapter(listOf(1, 2, 3, 4, 5)){
        }

        setHasOptionsMenu(true)

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNotificationBinding.inflate(inflater, container, false)


    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }


}