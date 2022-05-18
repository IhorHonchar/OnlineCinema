package com.honchar.onlinecinema.presentation.filmDetails.adapter

import com.honchar.onlinecinema.core.base.adapter.Holder
import com.honchar.onlinecinema.core.extensions.gone
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.databinding.ViewFilmsItemBinding
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel

class ActorHolder(private val onClick: (ActorModel) -> Unit): Holder<ActorModel, ViewFilmsItemBinding>() {

    override fun bind(binding: ViewFilmsItemBinding, item: ActorModel) {
        binding.tvFilmName.text = item.name
        binding.ivFilmPreview.loadImage(item.photo, 0)
        binding.tvFilmViews.gone()
        binding.tvFilmRate.gone()
        binding.root.setOnClickListener { onClick.invoke(item) }
    }
}