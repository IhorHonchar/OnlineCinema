package com.honchar.onlinecinema.presentation.home

import android.widget.Toast
import androidx.core.os.bundleOf
import com.google.android.material.tabs.TabLayoutMediator
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseFragmentAdapter
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.core.extensions.openFilm
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.FragmentHomeBinding
import com.honchar.onlinecinema.databinding.HomeCategoriesItemBinding
import com.honchar.onlinecinema.presentation.home.adapter.HomePageHolders
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    R.layout.fragment_home,
    FragmentHomeBinding::inflate
), FilmsCategory.FilmCategoryClickListener {

    override val viewModel: HomeViewModel by viewModel()

    private val adapter = BaseViewBindingAdapter()
        .map(
            HomeCategoriesItemBinding::inflate,
            HomePageHolders.FilmsCategoriesHolder(this)
        )

    override fun initViews() {
        binding.rvCategoriesFilms.adapter = adapter
        viewModel.getItems()
    }

    override fun subscribeData() {
        observeData(viewModel.itemsLiveData, adapter::loadItems)
        observeData(viewModel.topFilmsLiveData, ::initFilms)
    }

    override fun onFilmClick(film: FilmsCategory.Film) = openFilm(film)

    override fun onSeeAllClick(filmCategory: FilmsCategory.FilmCategory) {
        Toast.makeText(requireContext(), filmCategory.filmCategoryTitle, Toast.LENGTH_SHORT).show()
    }

    private fun initFilms(films: List<FilmsCategory.Film>) {
        initFilmPages(films)
    }

    private fun initFilmPages(films: List<FilmsCategory.Film>) {
        val fragments = mutableListOf<BaseFragmentAdapter.FragmentInfoContainer>()
        films.forEach { film ->
            fragments.add(
                BaseFragmentAdapter.FragmentInfoContainer(
                    FilmFragment::class.java,
                    bundleOf(FilmFragment.FILM to film)
                )
            )
        }
        binding.vpWoldPremier.adapter = BaseFragmentAdapter(childFragmentManager, lifecycle, fragments)
        TabLayoutMediator(binding.tabs, binding.vpWoldPremier) { _, _ -> }.attach()
    }
}