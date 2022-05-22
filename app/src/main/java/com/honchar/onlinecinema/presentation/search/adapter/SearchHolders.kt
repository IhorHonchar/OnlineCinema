package com.honchar.onlinecinema.presentation.search.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.databinding.FilterItemBinding
import com.honchar.onlinecinema.databinding.SearchItemBinding
import com.honchar.onlinecinema.presentation.search.model.FilterItem
import com.honchar.onlinecinema.presentation.search.model.FindFilmModel

object SearchHolders {

    class FoundFilmHolder(private val onClick: (FindFilmModel) -> Unit) :
        Holder<FindFilmModel, SearchItemBinding>() {

        override fun bind(binding: SearchItemBinding, item: FindFilmModel) {
            binding.ivFilmPreview.loadImage(item.poster, 0)
            binding.tvFilmName.text = item.name
            binding.tvFilmRate.text = item.rate
            binding.root.setClickListener { onClick.invoke(item) }
        }
    }

    class FilterHolder(private val onCloseClick: (FilterItem) -> Unit): Holder<FilterItem, FilterItemBinding>(){
        override fun bind(binding: FilterItemBinding, item: FilterItem) {
            binding.tvFilterName.text = item.name
            binding.ivFilterClose.setClickListener { onCloseClick.invoke(item) }
        }

    }
}