package com.honchar.onlinecinema.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.databinding.ActivityMainBinding
import com.honchar.onlinecinema.presentation.account.AccountFragment
import com.honchar.onlinecinema.presentation.home.HomeFragment
import com.honchar.onlinecinema.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    private var currentItem: Int = R.id.library

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.flMainContainer, HomeFragment())
            .commit()

        binding.nvBottom.setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.library -> {
                    HomeFragment()
                }
                R.id.search -> {
                    SearchFragment()
                }
                R.id.profile -> {
                    AccountFragment()
                }
                else -> AccountFragment()
            }
            openFragment(fragment)
            true
        }
    }

    fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragment::class.java.name)
            .add(R.id.flMainContainer, fragment)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 2) {
            supportFragmentManager.popBackStack()
        } else super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}