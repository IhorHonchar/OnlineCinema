package com.honchar.onlinecinema.presentation.films.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.SearchHorizontalItemBinding

class FilmHolder(private val onClick: (FilmsCategory.Film) -> Unit): Holder<FilmsCategory.Film, SearchHorizontalItemBinding>() {

    override fun bind(binding: SearchHorizontalItemBinding, item: FilmsCategory.Film) {
        binding.ivFilmPreview.loadImage(item.filmPoster, 0)
        binding.tvFilmName.text = item.filmName
        binding.tvFilmRate.text = item.filmRate
        binding.tvDesc.text = item.desc

        binding.root.setClickListener { onClick.invoke(item) }
    }
}