package com.honchar.onlinecinema.presentation.account

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.base.presentation.StubViewModel
import com.honchar.onlinecinema.core.extensions.loadCircleImage
import com.honchar.onlinecinema.databinding.FragmentEditAccountBinding
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.account.model.UserDataModel
import com.honchar.onlinecinema.presentation.login.LogInFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditAccountFragment: BaseFragment<FragmentEditAccountBinding>(
    R.layout.fragment_edit_account,
    FragmentEditAccountBinding::inflate
) {
    override val viewModel: StubViewModel by viewModel()

    private val userDataModel: UserDataModel = FilmsFactory.userData

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    override fun initViews() {
        super.initViews()
        userDataModel.let {
            binding.etName.setText(it.fullName)
            binding.etEmail.setText(it.email)
            binding.ivUserAvatar.loadCircleImage(it.avatar, R.drawable.ic_empty_user)
        }
    }

    private fun initListeners() {
        binding.button.setOnClickListener {
            FilmsFactory.userData.fullName = binding.etName.text.toString()
            Handler(Looper.getMainLooper()).postDelayed({
                Snackbar.make(it, R.string.success_save, Snackbar.LENGTH_SHORT).show()
            }, 500)
        }
    }

    companion object {
        const val USER = "ser_data"
    }
}