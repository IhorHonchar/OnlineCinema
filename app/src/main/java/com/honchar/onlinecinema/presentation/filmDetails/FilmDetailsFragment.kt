package com.honchar.onlinecinema.presentation.filmDetails

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.shape.ShapeAppearanceModel
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.base.presentation.BaseFragment
import com.honchar.onlinecinema.core.extensions.loadImage
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.databinding.FragmentFilmDetailsBinding
import com.honchar.onlinecinema.databinding.ViewFilmsItemBinding
import com.honchar.onlinecinema.presentation.filmDetails.adapter.ActorHolder
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel
import com.honchar.onlinecinema.presentation.filmDetails.model.FilmDetailsModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmDetailsFragment : BaseFragment<FragmentFilmDetailsBinding>(
    R.layout.fragment_film_details,
    FragmentFilmDetailsBinding::inflate
) {
    override val viewModel: FilmDetailsViewModel by viewModel()

    private val filmId: String?
        get() = arguments?.getString(FILM_ID)

    private val adapter = BaseViewBindingAdapter()
        .map(
            ViewFilmsItemBinding::inflate,
            ActorHolder(::onActorClick)
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        viewModel.getFilm("it")
    }

    override fun initViews() {
        super.initViews()
        binding.rvStars.adapter = adapter
    }

    override fun subscribeData() {
        observeData(viewModel.filmDetails, ::initData)
    }

    private fun initData(film: FilmDetailsModel) {
        with(binding) {
            ivPoster.loadImage(film.poster, 0)
            tvFilmName.text = film.name
            tvFilmDesc.text = film.description
            val likeColorRes =
                if (film.isFavorite) android.R.color.holo_red_dark else R.color.description_text_color
            ivLike.imageTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), likeColorRes))
            initChips(film.categories)
            adapter.loadItems(film.actors)
        }
    }

    private fun initChips(categories: List<CategoryModel>) {
        val chipCorners = ShapeAppearanceModel()
            .withCornerSize(requireContext().resources.getDimension(R.dimen.default_card_corner_radius))
        categories.forEach { category ->
            Chip(requireContext()).apply {
                text = category.name
                shapeAppearanceModel = chipCorners
                setOnClickListener { onChipClick(category) }
            }.let(binding.cgCategories::addView)
        }
    }

    private fun initListeners() {
        binding.ivLike.setClickListener(::onLikeClicked)
        binding.ivShare.setClickListener(::onShareClick)
        binding.ivPlay.setClickListener(::onPlayClick)
    }

    private fun onLikeClicked() {

    }

    private fun onShareClick() {

    }

    private fun onPlayClick() {

    }

    private fun onActorClick(actorModel: ActorModel) {

    }

    private fun onChipClick(category: CategoryModel) {
        Toast.makeText(requireContext(), category.id.plus(category.name), Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val FILM_ID = "film_id"
    }
}