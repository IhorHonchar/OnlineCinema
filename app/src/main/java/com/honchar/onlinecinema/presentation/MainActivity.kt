package com.honchar.onlinecinema.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.databinding.ActivityMainBinding
import com.honchar.onlinecinema.presentation.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.flMainContainer, HomeFragment())
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}