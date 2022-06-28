package com.honchar.onlinecinema.core.di

import com.honchar.onlinecinema.core.base.presentation.StubViewModel
import com.honchar.onlinecinema.presentation.account.AccountViewModel
import com.honchar.onlinecinema.presentation.account.AccountViewModelImpl
import com.honchar.onlinecinema.presentation.filmDetails.FilmDetailsViewModel
import com.honchar.onlinecinema.presentation.filmDetails.FilmDetailsViewModelImpl
import com.honchar.onlinecinema.presentation.home.HomeViewModel
import com.honchar.onlinecinema.presentation.home.HomeViewModelImpl
import com.honchar.onlinecinema.presentation.search.SearchViewModel
import com.honchar.onlinecinema.presentation.search.SearchViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel<StubViewModel> { StubViewModel() }
    viewModel<HomeViewModel> { HomeViewModelImpl() }
    viewModel<FilmDetailsViewModel> { FilmDetailsViewModelImpl() }
    viewModel<SearchViewModel> { SearchViewModelImpl() }
    viewModel<AccountViewModel> { AccountViewModelImpl() }
}