package com.honchar.onlinecinema.presentation.search.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.FilterItemBinding
import com.honchar.onlinecinema.databinding.SearchItemBinding
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel
import com.honchar.onlinecinema.presentation.search.model.FilterItem
import com.honchar.onlinecinema.presentation.search.model.FindFilmModel

object SearchHolders {

    class FoundFilmHolder(private val onClick: (FilmsCategory.Film) -> Unit) :
        Holder<FilmsCategory.Film, SearchItemBinding>() {

        override fun bind(binding: SearchItemBinding, item: FilmsCategory.Film) {
            binding.ivFilmPreview.loadImage(item.filmPoster, 0)
            binding.tvFilmName.text = item.filmName
            binding.tvFilmRate.text = item.filmRate
            binding.root.setClickListener { onClick.invoke(item) }
        }
    }

    class FilterHolder(private val onCloseClick: (CategoryModel) -> Unit): Holder<CategoryModel, FilterItemBinding>(){
        override fun bind(binding: FilterItemBinding, item: CategoryModel) {
            binding.tvFilterName.text = binding.root.context.getString(item.name)
            binding.ivFilterClose.setClickListener { onCloseClick.invoke(item) }
        }

    }
}