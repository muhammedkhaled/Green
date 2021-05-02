package com.muhammad.green.ui.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.muhammad.green.ui.landing.ui.OnBoardingFragment

class OnBoardingSliderPageAdapter(fm: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fm, behavior) {
    override fun getItem(position: Int): Fragment {
        return OnBoardingFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 3
    }
}