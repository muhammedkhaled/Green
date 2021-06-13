package com.muhammad.green.views.landing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.muhammad.green.views.landing.response.Article
import com.muhammad.green.views.landing.response.Slider
import com.muhammad.green.views.landing.ui.OnBoardingFragment

class OnBoardingSliderPageAdapter(fm: FragmentManager, behavior: Int,
                                  private val articles: ArrayList<Article>,
                                  private val images: ArrayList<Slider> ) :
    FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment = OnBoardingFragment.newInstance(position, articles, images)

    override fun getCount() = articles.size

}