package com.honchar.onlinecinema.presentation.home.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.HomeCategoriesItemBinding
import com.honchar.onlinecinema.databinding.ViewFilmsItemBinding
import com.honchar.onlinecinema.databinding.WorldPremierItemBinding
import com.honchar.onlinecinema.presentation.home.model.WorldPremierFilm

object HomePageHolders {

    class FilmsCategoriesHolder(
        private val clickListener: FilmsCategory.FilmCategoryClickListener,
    ): Holder<FilmsCategory.FilmCategory, HomeCategoriesItemBinding>(){

        override fun bind(binding: HomeCategoriesItemBinding, item: FilmsCategory.FilmCategory) {
            binding.categoryFilm.loadFilmCategory(item)
            binding.categoryFilm.setListener(clickListener)
        }
    }

    class WorldPremierHolder(
        private val onItemClick: (FilmsCategory.Film) -> Unit
    ): Holder<FilmsCategory.Film, WorldPremierItemBinding>(){

        override fun bind(binding: WorldPremierItemBinding, item: FilmsCategory.Film) {
            binding.ivPoster.loadImage(item.filmPoster, item.placeholder)
            binding.tvFilmName.text = item.filmName
            binding.tvRate.text = item.filmRate
            binding.tvRelease.text = item.filmRelease
            binding.cvPoster.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }

}