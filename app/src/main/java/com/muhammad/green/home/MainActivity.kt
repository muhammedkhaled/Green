package com.muhammad.green.home


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muhammad.green.R
import com.muhammad.green.databinding.ActivityMainBinding


class  MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

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
//            navController.popBackStack()
            navController.navigate(R.id.detailsFragment)
        }

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.detailsFragment) {
//                binding.fab.setBackgroundColor(ContextCompat.getColor(this, R.color.Astral))
                findViewById<ConstraintLayout>(R.id.content_home_conLL).visibility = View.INVISIBLE
                findViewById<Guideline>(R.id.content_home_guideline_h1).visibility = View.INVISIBLE

            } else {
//                binding.fab.setBackgroundColor(ContextCompat.getColor(this, R.color.gray))
                findViewById<ConstraintLayout>(R.id.content_home_conLL).visibility = View.VISIBLE
                findViewById<Guideline>(R.id.content_home_guideline_h1).visibility = View.VISIBLE

            }
        }

  
    }

}