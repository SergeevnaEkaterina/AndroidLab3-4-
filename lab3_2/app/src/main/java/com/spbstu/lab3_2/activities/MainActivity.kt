package com.spbstu.lab3_2.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.spbstu.lab3_2.R
import com.spbstu.lab3_2.databinding.Activity1Binding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToSecond.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
        binding.drawerNavView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.aboutActivity) {
                binding.drawerLayout.closeDrawer(GravityCompat.START, true)
                startActivity(Intent(this, ActivityAbout::class.java))
            }
            true
        }
    }
}