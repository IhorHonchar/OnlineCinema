package com.honchar.onlinecinema.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.core.base.presentation.StubViewModel
import com.honchar.onlinecinema.databinding.FragmentLogInBinding
import com.honchar.onlinecinema.presentation.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LogInFragment: BaseFragment<FragmentLogInBinding>(
    R.layout.fragment_log_in,
    FragmentLogInBinding::inflate
) {
    override val viewModel: StubViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
        initTextListeners()
    }

    private fun initClickListeners() {
        binding.bLogIn.setOnClickListener {
            val email = binding.etEmail.text?.toString()
            val pass = binding.etPass.text?.toString()
            val errorMes = getString(R.string.incorrect_data)
            when {
                email.isNullOrEmpty() -> {
                    binding.tiEmail.isErrorEnabled = true
                    binding.tiEmail.error = errorMes
                }
                pass.isNullOrEmpty() -> {
                    binding.tiPass.isErrorEnabled = false
                    binding.tiPass.error = errorMes
                }
                else -> { openApp(false) }
            }
        }

        binding.tvGuest.setOnClickListener { openApp(true) }
    }

    private fun openApp(isGuest: Boolean) {
        startActivity(Intent(requireContext(), MainActivity::class.java), bundleOf(MainActivity.IS_GUEST to isGuest))
    }

    private fun initTextListeners() {
        binding.etEmail.doAfterTextChanged {
            val error = if (it.isNullOrEmpty()) getString(R.string.incorrect_data) else null
            binding.tiEmail.error = error
            binding.tiEmail.isErrorEnabled = error != null
        }

        binding.etPass.doAfterTextChanged {
            val error = if (it.isNullOrEmpty()) getString(R.string.incorrect_data) else null
            binding.tiPass.error = error
            binding.tiPass.isErrorEnabled = error != null
        }
    }
}