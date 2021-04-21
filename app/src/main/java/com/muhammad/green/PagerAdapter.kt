package com.muhammad.green

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal class PagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
    private val count = 4



    override fun getCount() = count

    override fun getPageTitle(position: Int): CharSequence {
        return "Page $position"
    }

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return PageFragment.newInstance(position + 1, position == count - 1)
    }
}