package com.spbstu.lab3_3.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.spbstu.lab3_3.databinding.Activity2Binding
import com.spbstu.lab3_3.R

class Activity2: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToFirst.setOnClickListener {
            finish()
        }
        binding.bnToThird.setOnClickListener {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
        }
        binding.drawerNavView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.aboutActivity) {
                binding.drawerLayout.closeDrawer(GravityCompat.START, true)
                startActivity(Intent(this, ActivityAbout::class.java))
            }
            true
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}