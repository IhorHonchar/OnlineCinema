package com.honchar.onlinecinema.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.honchar.onlinecinema.core.navigation.NavigationHandler
import com.honchar.onlinecinema.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), NavigationHandler {
    private var _binding: ActivityLoginBinding? = null
    private val binding: ActivityLoginBinding
    get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayFragment(SplashFragment(), SplashFragment::class.java.name)
    }

    override fun displayFragment(frag: Fragment, backStack: String?) {
        supportFragmentManager.beginTransaction()
            .replace(binding.flContainer.id, frag).apply {
                backStack?.let {
                    addToBackStack(it)
                }
            }
            .commit()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}