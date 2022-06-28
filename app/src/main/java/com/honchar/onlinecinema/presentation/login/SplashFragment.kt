package com.honchar.onlinecinema.presentation.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.base.presentation.StubViewModel
import com.honchar.onlinecinema.databinding.FragmentSplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>(
    R.layout.fragment_splash,
    FragmentSplashBinding::inflate
) {
    override val viewModel: StubViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            navigationHandler?.displayFragment(LogInFragment(), LogInFragment::class.java.name)
        }, 2000)
    }
}