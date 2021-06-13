package com.muhammad.green.views.landing.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.tabs.TabLayout
import com.muhammad.green.views.home.ui.MainActivity
import com.muhammad.green.R
import com.muhammad.green.data.network.GeneralDataApi
import com.muhammad.green.data.network.IntroApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.ActivityLandingBinding
import com.muhammad.green.views.home.repository.GeneralDataRepository
import com.muhammad.green.views.home.viewModels.GeneralDataViewModel
import com.muhammad.green.views.landing.OnBoardingSliderPageAdapter
import com.muhammad.green.views.landing.repository.IntroRepository
import com.muhammad.green.views.landing.response.Article
import com.muhammad.green.views.landing.response.Slider
import com.muhammad.green.views.landing.viewModels.IntroViewModel
import com.muhammad.green.views.registration.ui.RegistrationActivity
import com.muhammad.green.views.registration.viewModels.ViewModelFactory
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.utiles.changeLayoutDirection
import net.Aqua_waterfliter.joborder.utiles.disableDayNight
import net.Aqua_waterfliter.joborder.utiles.visible
import java.util.*
import kotlin.collections.ArrayList

class LandingActivity : AppCompatActivity() {
    private lateinit var viewModel: IntroViewModel

    private lateinit var loadingProgress: ProgressBar
    private lateinit var adapter: OnBoardingSliderPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        setUpViewModel()
        loadingProgress = findViewById<ProgressBar>(R.id.intro_loadingProgress)
        loadingProgress.visible(true)
        viewModel.getIntroData()
        observeData()

        changeLayoutDirection(true)
        disableDayNight()
    }

    fun hideStarterFragment() {
        val starterView = findViewById<FrameLayout>(R.id.fragment_view)
        val introView = findViewById<ConstraintLayout>(R.id.intro_view)
        starterView.visibility = View.GONE
        introView.visibility = View.VISIBLE

        val leaveLandingPage = findViewById<Button>(R.id.landingLogin_btn)
        val skipBtn = findViewById<Button>(R.id.landingSkip_btn)



        leaveLandingPage.setOnClickListener { leaveLandingPage() }
        skipBtn.setOnClickListener { skip() }
    }

    private fun leaveLandingPage() {
        val intent = Intent(this@LandingActivity, RegistrationActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun skip() {
        val intent = Intent(this@LandingActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setUpViewModel() {
        val remoteDataSource = RemoteDataSource.buildApi(IntroApi::class.java)
        val repository = IntroRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(IntroViewModel::class.java)
    }

    private fun observeData(){
        lifecycleScope.launchWhenCreated {
            viewModel.introData.collect {
                when(it){
                    is ResultWrapper.Loading -> {
                        loadingProgress.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        loadingProgress.visible(false)
                        setUpViewPager(it.value.articles, it.value.sliders)

                    }
                    is ResultWrapper.GenericError -> {
                        loadingProgress.visible(false)

                    }
                }
            }
        }

    }

    private fun setUpViewPager(articles: ArrayList<Article>, images: ArrayList<Slider>){
        val viewPager = findViewById<ViewPager>(R.id.pagerIntroSlider)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val adapter = OnBoardingSliderPageAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
            , articles, images)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
//                if (position == 2) {
//                    leaveLandingPage.visibility = View.VISIBLE
//                } else {
//                    leaveLandingPage.visibility = View.INVISIBLE
//                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}