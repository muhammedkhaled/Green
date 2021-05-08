package com.muhammad.green.views.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.databinding.FragmentFavoriteBinding
import com.muhammad.green.views.home.adapters.FavAdapter
import net.Aqua_waterfliter.joborder.base.BaseFragment

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFavoriteBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manager1 = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.myFavCasesRv.layoutManager = manager1

        binding.myFavCasesRv.adapter = FavAdapter(listOf(1, 2, 3, 4, 5)){
        }

        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }
}