package com.honchar.onlinecinema.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.navigation.NavigationHandler
import com.honchar.onlinecinema.databinding.ActivityMainBinding
import com.honchar.onlinecinema.presentation.account.AccountFragment
import com.honchar.onlinecinema.presentation.home.HomeFragment
import com.honchar.onlinecinema.presentation.search.SearchFragment

class MainActivity : AppCompatActivity(), NavigationHandler {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayFragment(HomeFragment(), HomeFragment::class.java.name)

        binding.nvBottom.setOnItemSelectedListener {
            navigationItemClick(it)
            true
        }

        intent.extras?.getBoolean(IS_GUEST)?.let {

        }
    }

    override fun displayFragment(frag: Fragment, backStack: String?) {
        supportFragmentManager.beginTransaction()
            .replace(binding.flMainContainer.id, frag).apply {
                backStack?.let {
                    addToBackStack(it)
                }
            }
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

    private fun navigationItemClick(item: MenuItem) {
        val fragment = when (item.itemId) {
            R.id.library -> {
                HomeFragment()
            }
            R.id.search -> {
                SearchFragment()
            }
            R.id.profile -> {
                AccountFragment()
            }
            else -> null
        }
        fragment?.let { displayFragment(it, it.javaClass::class.java.name) }
    }

    companion object {
        const val IS_GUEST = "is_guest"
    }
}