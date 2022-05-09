package com.honchar.onlinecinema.core.di

import com.honchar.onlinecinema.presentation.home.HomeViewModel
import com.honchar.onlinecinema.presentation.home.IHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel<IHomeViewModel> { HomeViewModel() }
}