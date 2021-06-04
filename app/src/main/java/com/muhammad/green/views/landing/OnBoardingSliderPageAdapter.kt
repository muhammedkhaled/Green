package com.muhammad.green.views.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.muhammad.green.views.landing.ui.OnBoardingFragment

class OnBoardingSliderPageAdapter(fm: FragmentManager, behavior: Int) :
    FragmentPagerAdapter(fm, behavior) {


    override fun getItem(position: Int): Fragment = OnBoardingFragment.newInstance(position)


    override fun getCount() = 3

}