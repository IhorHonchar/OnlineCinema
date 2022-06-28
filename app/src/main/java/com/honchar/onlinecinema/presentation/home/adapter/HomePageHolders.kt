package com.honchar.onlinecinema.presentation.home.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.HomeCategoriesItemBinding

object HomePageHolders {

    class FilmsCategoriesHolder(
        private val clickListener: FilmsCategory.FilmCategoryClickListener,
    ): Holder<FilmsCategory.FilmCategory, HomeCategoriesItemBinding>(){

        override fun bind(binding: HomeCategoriesItemBinding, item: FilmsCategory.FilmCategory) {
            binding.categoryFilm.loadFilmCategory(item)
            item.films
            binding.categoryFilm.setListener(clickListener)
        }
    }

}