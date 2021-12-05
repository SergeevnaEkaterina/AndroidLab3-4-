package com.spbstu.lab3_5.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import spbstu.lab3_5.R
import spbstu.lab3_5.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity: AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        findViewById<NavigationView>(R.id.drawer_nav_view)
            .setupWithNavController(navController)
        val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )
        binding.drawerNavView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.aboutActivity) {
                binding.drawerLayout.closeDrawer(GravityCompat.START, true)
                navController.navigate(R.id.to_activity_about)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}