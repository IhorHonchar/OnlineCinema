package com.honchar.onlinecinema.presentation.search.searchFilter

import android.os.Bundle
import android.view.View
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.core.extensions.openFilm
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.databinding.FilterItemBinding
import com.honchar.onlinecinema.databinding.FragmentSearchFilterBinding
import com.honchar.onlinecinema.databinding.SearchItemBinding
import com.honchar.onlinecinema.presentation.search.SearchViewModel
import com.honchar.onlinecinema.presentation.search.adapter.SearchHolders
import com.honchar.onlinecinema.presentation.search.model.FilterItem
import com.honchar.onlinecinema.presentation.search.model.FindFilmModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFilterFragment:  BaseFragment<FragmentSearchFilterBinding>(
    R.layout.fragment_search_filter,
    FragmentSearchFilterBinding::inflate
){
    override val viewModel: SearchViewModel by sharedViewModel()

    private val filmsAdapter = BaseViewBindingAdapter()
        .map(
            SearchItemBinding::inflate,
            SearchHolders.FoundFilmHolder(::onFilmClick)
        )

    private val filtersAdapter = BaseViewBindingAdapter()
        .map(
            FilterItemBinding::inflate,
            SearchHolders.FilterHolder(::onFilterClose)
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        viewModel.getFilters()
        viewModel.findFilm("")
    }

    override fun initViews() {
        super.initViews()
        if (binding.rvFilms.adapter == null)
            binding.rvFilms.adapter = filmsAdapter
        if (binding.rvFilters.adapter == null)
            binding.rvFilters.adapter = filtersAdapter
    }

    override fun subscribeData() {
        super.subscribeData()
        observeData(viewModel.filmsLiveData, ::showResult)
        observeData(viewModel.filtersLiveData, ::loadFilters)
    }

    private fun initListeners() {
        binding.ivFilters.setClickListener(::onFilterBtnClick)
    }

    private fun showResult(result: List<FindFilmModel>){
        filmsAdapter.loadItems(result)
    }

    private fun loadFilters(filtersList: List<FilterItem>){
        filtersAdapter.loadItems(filtersList)
    }

    private fun onFilmClick(film: FindFilmModel) = openFilm(film.id)

    private fun onFilterClose(filter: FilterItem) {

    }

    private fun onFilterBtnClick() {

    }
}