package com.honchar.onlinecinema.presentation.home

import android.os.Bundle
import android.view.View
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home,
    FragmentHomeBinding::inflate
) {

    override val viewModel: IHomeViewModel by viewModel()

    override fun initViews() {
        TODO("Not yet implemented")
    }

    override fun subscribeData() {
        TODO("Not yet implemented")
    }

}