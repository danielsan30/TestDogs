package com.danielitos.testdogs.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danielitos.testdogs.R
import com.danielitos.testdogs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        binding.apply {
            customNavbar.navButton.setOnClickListener {
                finish()
            }
        }
    }
}