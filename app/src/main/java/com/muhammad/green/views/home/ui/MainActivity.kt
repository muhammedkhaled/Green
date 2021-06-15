package com.muhammad.green.views.home.ui

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muhammad.green.R
import com.muhammad.green.databinding.ActivityMainBinding
import net.Aqua_waterfliter.joborder.utiles.changeLayoutDirection
import net.Aqua_waterfliter.joborder.utiles.disableDayNight


class  MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeLayoutDirection(true)
        disableDayNight()

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowHomeEnabled(true)


        val navView: BottomNavigationView = binding.bottomNavigationView
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.home_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_callUs, R.id.navigation_favorite, R.id.navigation_home,
                R.id.navigation_notification, R.id.navigation_menu
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.fab.setOnClickListener{
//            navController.popBackStack(R.id.navigation_home, false)
            navController.popBackStack()
            navController.navigate(R.id.navigation_home)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.navigation_home -> {
                    showBottomNav(true)
                    binding.fab.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.Astral));
                    binding.bottomNavigationView.itemIconTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray))
                }

                R.id.navigation_callUs -> {
                    showBottomNav(true)
                    binding.fab.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray));
                }

                R.id.navigation_favorite -> {
                    showBottomNav(true)
                    binding.fab.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray));
                }

                R.id.navigation_notification -> {
                    showBottomNav(true)
                    binding.fab.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray));
                }

                R.id.navigation_menu -> {
                    showBottomNav(true)
                    binding.fab.backgroundTintList =
                        ColorStateList.valueOf(ContextCompat.getColor(this, R.color.gray));
                }

               /* R.id.caseDetailsFragment -> {
                    showBottomNav(false)
                    *//*val emerald = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.emerald))
                    findViewById<AppBarLayout>(R.id.appBar).background.setTintList(emerald)
                    findViewById<Toolbar>(R.id.toolbar)
                        .setTitleTextColor(ContextCompat.getColor(this, R.color.white))*//*
                }*/

                else -> showBottomNav(false)
            }
        }
    }


    private fun showBottomNav(isVisible: Boolean) {
        binding.bottomAppBar.visibility = if (isVisible) View.VISIBLE else View.GONE
        binding.fab.visibility = if (isVisible) View.VISIBLE else View.GONE

        /*val transparent = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.transparent))
        val green = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.emerald_light))

        findViewById<AppBarLayout>(R.id.appBar)
            .background.setTintList(if (isVisible) transparent else green)
        findViewById<Toolbar>(R.id.toolbar).setTitleTextColor(
            if (isVisible) ContextCompat.getColor(this, R.color.black) else
                ContextCompat.getColor(this, R.color.white))*/
    }

    override fun onSupportNavigateUp(): Boolean {
        return (Navigation.findNavController(this, R.id.home_host_fragment).navigateUp()
                || super.onSupportNavigateUp())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this, R.id.home_host_fragment)
        if (item.itemId == R.id.share) {
            // open implicit intent to share app link
            return false
        }
        return (NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item))
    }

}