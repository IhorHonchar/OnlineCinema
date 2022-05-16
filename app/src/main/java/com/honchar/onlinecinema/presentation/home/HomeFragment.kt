package com.honchar.onlinecinema.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.FragmentHomeBinding
import com.honchar.onlinecinema.databinding.HomeCategoriesItemBinding
import com.honchar.onlinecinema.databinding.WorldPremierItemBinding
import com.honchar.onlinecinema.presentation.home.adapter.EndlessAdapter
import com.honchar.onlinecinema.presentation.home.adapter.HomePageHolders
import com.honchar.onlinecinema.presentation.home.model.WorldPremierFilm
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home,
    FragmentHomeBinding::inflate
), FilmsCategory.FilmCategoryClickListener {

    private val adapter = BaseViewBindingAdapter()
        .map(
            HomeCategoriesItemBinding::inflate,
            HomePageHolders.FilmsCategoriesHolder(this)
        )

    private val worldPremierAdapter = EndlessAdapter()
        .map(
            WorldPremierItemBinding::inflate,
            HomePageHolders.WorldPremierHolder(::onFilmClick)
        ) as EndlessAdapter

    override val viewModel: IHomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHorizontalAdapter()
    }

    override fun initViews() {
        binding.rvCategoriesFilms.adapter = adapter
        viewModel.getItems()
    }

    override fun subscribeData() {
        observeData(viewModel.itemsLiveData, adapter::loadItems)
        observeData(viewModel.topFilmsLiveData, worldPremierAdapter::loadItems)
    }

    override fun onFilmClick(film: FilmsCategory.Film) {
        Toast.makeText(requireContext(), film.filmId, Toast.LENGTH_SHORT).show()
    }

    override fun onSeeAllClick(filmCategory: FilmsCategory.FilmCategory) {
        Toast.makeText(requireContext(), filmCategory.filmCategoryTitle, Toast.LENGTH_SHORT).show()
    }

    private fun initHorizontalAdapter() {
        val lm = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL)
        lm.setPostLayoutListener(CarouselZoomPostLayoutListener())
        lm.scrollToPosition(Integer.MAX_VALUE / 2)
        binding.rvWoldPremier.layoutManager = lm
        binding.rvWoldPremier.setHasFixedSize(false)
        binding.rvWoldPremier.addOnScrollListener(CenterScrollListener())
        binding.rvWoldPremier.adapter = worldPremierAdapter
    }



}