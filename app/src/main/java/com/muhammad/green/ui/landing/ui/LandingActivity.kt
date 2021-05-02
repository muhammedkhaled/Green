package com.muhammad.green.ui.landing.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.tabs.TabLayout
import com.muhammad.green.ui.home.ui.MainActivity
import com.muhammad.green.R
import com.muhammad.green.ui.landing.OnBoardingSliderPageAdapter
import com.muhammad.green.ui.registration.ui.RegistrationActivity
import java.util.*

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        // set local to ar to change app direction to rtl and language to ar
        val locale = Locale("ar")
        Locale.setDefault(locale)
        val config = baseContext.resources.configuration
        config.setLocale(locale)
        createConfigurationContext(config)
    }

    fun hideStarterFragment() {
        val starterView = findViewById<FrameLayout>(R.id.fragment_view)
        val introView = findViewById<ConstraintLayout>(R.id.intro_view)
        starterView.visibility = View.GONE
        introView.visibility = View.VISIBLE
        val viewPager = findViewById<ViewPager>(R.id.pagerIntroSlider)
        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        val leaveLandingPage = findViewById<Button>(R.id.landingLogin_btn)
        val skipBtn = findViewById<Button>(R.id.landingSkip_btn)
        val adapter = OnBoardingSliderPageAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
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
}