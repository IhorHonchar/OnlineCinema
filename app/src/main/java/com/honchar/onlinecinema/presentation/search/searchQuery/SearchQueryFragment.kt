package com.honchar.onlinecinema.presentation.search.searchQuery

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.core.extensions.openFilm
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.FragmentSearchQueryBinding
import com.honchar.onlinecinema.databinding.SearchItemBinding
import com.honchar.onlinecinema.presentation.search.SearchViewModel
import com.honchar.onlinecinema.presentation.search.adapter.SearchHolders
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchQueryFragment: BaseFragment<FragmentSearchQueryBinding>(
    R.layout.fragment_search_query,
    FragmentSearchQueryBinding::inflate
) {

    override val viewModel: SearchViewModel by sharedViewModel()

    private val filmsAdapter = BaseViewBindingAdapter()
        .map(
            SearchItemBinding::inflate,
            SearchHolders.FoundFilmHolder(::onFilmClick)
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.findFilm(null)
        binding.etSearch.doAfterTextChanged { result ->
            result?.let { viewModel.findFilm(it.toString()) }
        }
    }

    override fun initViews() {
        super.initViews()
        if (binding.rvFilms.adapter == null)
            binding.rvFilms.adapter = filmsAdapter
    }

    override fun subscribeData() {
        super.subscribeData()
        observeData(viewModel.filmsLiveData, ::showResult)
    }

    private fun showResult(result: List<FilmsCategory.Film>){
        filmsAdapter.loadItems(result)
    }

    private fun onFilmClick(film: FilmsCategory.Film) = openFilm(film)
}