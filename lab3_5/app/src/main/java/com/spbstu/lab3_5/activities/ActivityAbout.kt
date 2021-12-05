package com.spbstu.lab3_5.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import spbstu.lab3_5.databinding.ActivityAboutBinding


class ActivityAbout: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}