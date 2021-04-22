package com.muhammad.green

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.muhammad.green.home.OrderPager1Fragment
import com.muhammad.green.home.OrderPager2Fragment
import com.muhammad.green.home.OrderPager3Fragment

internal class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    private val list = listOf(OrderPager1Fragment(), OrderPager2Fragment(), OrderPager3Fragment())

    override fun getCount() = list.size

    override fun getItem(position: Int): Fragment {
        return list[position]
    }
}