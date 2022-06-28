package com.honchar.onlinecinema.presentation.home

import android.os.Bundle
import android.view.View
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.base.presentation.StubViewModel
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.extensions.openFilm
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.FragmentFilmBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmFragment: BaseFragment<FragmentFilmBinding>(
    R.layout.fragment_film,
    FragmentFilmBinding::inflate
) {

    override val viewModel: StubViewModel by viewModel()

    private val item: FilmsCategory.Film?
    get() = arguments?.getParcelable(FILM)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item?.let { film ->
            binding.ivPoster.loadImage(film.filmPoster, film.placeholder)
            binding.tvFilmName.text = film.filmName
            binding.tvRate.text = film.filmRate
            binding.tvRelease.text = film.filmRelease
            binding.cvPoster.setOnClickListener {
                openFilm(film.filmId)
            }
        }
    }

    companion object {
        const val FILM = "film_model"
    }

}