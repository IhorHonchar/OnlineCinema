package com.honchar.onlinecinema.core.di

import com.honchar.onlinecinema.presentation.IMainViewModel
import com.honchar.onlinecinema.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {

    viewModel<IMainViewModel> { MainViewModel() }
}