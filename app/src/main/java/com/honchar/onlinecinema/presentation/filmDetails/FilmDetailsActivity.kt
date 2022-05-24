package com.honchar.onlinecinema.presentation.filmDetails

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.chip.Chip
import com.google.android.material.shape.ShapeAppearanceModel
import com.honchar.onlinecinema.R
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.extensions.observeData
import com.honchar.onlinecinema.core.extensions.setClickListener
import com.honchar.onlinecinema.core.views.AppBarStateChangeListener
import com.honchar.onlinecinema.databinding.ActivityFilmDetailsBinding
import com.honchar.onlinecinema.databinding.ViewFilmsItemBinding
import com.honchar.onlinecinema.presentation.filmDetails.adapter.ActorHolder
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel
import com.honchar.onlinecinema.presentation.filmDetails.model.FilmDetailsModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmDetailsActivity : AppCompatActivity() {

    private var _binding: ActivityFilmDetailsBinding? = null
    private val binding get() = _binding!!

    private var exoPlayer: ExoPlayer? = null

    private val viewModel: FilmDetailsViewModel by viewModel()

    private val filmId: String?
        get() = intent.getStringExtra(FILM_ID)

    private val adapter = BaseViewBindingAdapter()
        .map(
            ViewFilmsItemBinding::inflate,
            ActorHolder(::onActorClick)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityFilmDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListeners()
        initPlayer()
        subscribeData()
        viewModel.getFilm(filmId.orEmpty())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        exoPlayer?.stop()
    }

    private fun initViews() {
        binding.rvStars.adapter = adapter
    }

    private fun subscribeData() {
        observeData(viewModel.filmDetails, ::initData)
    }

    private fun initData(film: FilmDetailsModel) {
        with(binding) {
            tvFilmName.text = film.name
            tvFilmDesc.text = film.description
            initChips(film.categories)
            adapter.loadItems(film.actors)
        }

        try {
            val mediaItem: MediaItem = MediaItem.fromUri(Uri.parse(film.videoUrl))
            exoPlayer?.setMediaItem(mediaItem)
            exoPlayer?.prepare()
        } catch (e: Exception) {
            Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    private fun  initPlayer() {
        exoPlayer = ExoPlayer.Builder(this).build().also { exoPlayer ->
            binding.exoPlayerView.player = exoPlayer
        }
        exoPlayer?.playWhenReady = false
    }

    private fun initChips(categories: List<CategoryModel>) {
        val chipCorners = ShapeAppearanceModel()
            .withCornerSize(this.resources.getDimension(R.dimen.default_card_corner_radius))
        categories.forEach { category ->
            Chip(this).apply {
                text = category.name
                shapeAppearanceModel = chipCorners
                setOnClickListener { onChipClick(category) }
            }.let(binding.cgCategories::addView)
        }
    }

    private fun initListeners() {
        binding.ivMore.setClickListener(::onMoreClick)

        binding.appBarLayout.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout, state: State) {
                when(state) {
                    State.COLLAPSED->{

                    }
                    State.EXPANDED->{

                    }
                    State.IDLE->{

                    }
                }
            }

        })
    }

    private fun onLikeClicked() {

    }

    private fun onShareClick() {

    }


    private fun onMoreClick() {

    }

    private fun onActorClick(actorModel: ActorModel) {

    }

    private fun onChipClick(category: CategoryModel) {
        Toast.makeText(this, category.id.plus(category.name), Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val FILM_ID = "film_id"
    }
}