package com.muhammad.green.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class OnBoardingSliderPageAdapter(fm: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return OnBoardingFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 3
    }
}