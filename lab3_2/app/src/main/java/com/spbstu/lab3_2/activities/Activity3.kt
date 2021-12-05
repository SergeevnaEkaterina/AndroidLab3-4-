package com.spbstu.lab3_2.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.spbstu.lab3_2.R
import com.spbstu.lab3_2.databinding.Activity3Binding

class Activity3: AppCompatActivity() {

    private val GO_TO_FIRST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToFirst.setOnClickListener {
            setResult(GO_TO_FIRST)
            finish()
        }
        binding.bnToSecond.setOnClickListener {
            finish()
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
        onBackPressed()
        return true
    }
}