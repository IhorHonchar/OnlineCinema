package com.honchar.onlinecinema.presentation.filmDetails

import android.content.Intent
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
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.ActivityFilmDetailsBinding
import com.honchar.onlinecinema.databinding.ViewFilmsItemBinding
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.filmDetails.adapter.ActorHolder
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel
import com.honchar.onlinecinema.presentation.filmDetails.model.FilmDetailsModel
import com.honchar.onlinecinema.presentation.films.FilmsActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FilmDetailsActivity : AppCompatActivity() {

    private var _binding: ActivityFilmDetailsBinding? = null
    private val binding get() = _binding!!

    private var exoPlayer: ExoPlayer? = null

    private val viewModel: FilmDetailsViewModel by viewModel()

    private val film: FilmsCategory.Film?
        get() = intent.getParcelableExtra(FILM)

    private val adapter = BaseViewBindingAdapter()
        .map(
            ViewFilmsItemBinding::inflate,
            ActorHolder(::onActorClick)
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityFilmDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initPlayer()
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews() {
        binding.rvStars?.adapter = adapter

        film?.let {
            with(binding) {
                tvFilmName?.text = it.filmName
                tvFilmDesc?.text = it.desc
                ivLike?.isChecked = it.isLike
                ivWatchLater?.isChecked = it.isLater
                initChips(it.categories)
                adapter.loadItems(it.actors)
            }

            try {
                val mediaItem: MediaItem = MediaItem.fromUri(Uri.parse(it.videoUrl))
                exoPlayer?.setMediaItem(mediaItem)
                exoPlayer?.prepare()
            } catch (e: Exception) {
                Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    private fun initPlayer() {
        viewModel.playerLiveData.value?.let {
            binding.exoPlayerView.player = it
        } ?: run {
            exoPlayer = ExoPlayer.Builder(this).build().also { exoPlayer ->
                exoPlayer.playWhenReady = false
                viewModel.savePlayer(exoPlayer)
                binding.exoPlayerView.player = exoPlayer
            }
        }
    }

    private fun initChips(categories: List<CategoryModel>) {
        val chipCorners = ShapeAppearanceModel()
            .withCornerSize(this.resources.getDimension(R.dimen.default_card_corner_radius))
        categories.forEach { category ->
            Chip(this).apply {
                text = getString(category.name)
                shapeAppearanceModel = chipCorners
                setOnClickListener { onChipClick(category) }
            }.let{
                binding.cgCategories?.addView(it)
            }
        }
    }

    private fun initListeners() {

        binding.appBarLayout?.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
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

        binding.ivLike?.setOnCheckedChangeListener { _, isChecked ->
            film?.isLike = isChecked
            FilmsFactory.getFilms().find { it.filmId == film?.filmId }?.isLike = isChecked
        }
        binding.ivWatchLater?.setOnCheckedChangeListener { _, isChecked ->
            film?.isLater = isChecked
            FilmsFactory.getFilms().find { it.filmId == film?.filmId }?.isLater = isChecked
        }
        binding.ivShare?.setClickListener(::onShareClick)
    }

    private fun onShareClick() {

    }

    private fun onActorClick(actorModel: ActorModel) {

    }

    private fun onChipClick(category: CategoryModel) {
        val arrayList = ArrayList(FilmsFactory.getFilms().filter { it.categories.contains(category) })
        startActivity(Intent(this, FilmsActivity::class.java).apply {
            putParcelableArrayListExtra(FilmsActivity.FILMS, arrayList)
        })
    }

    companion object {
        const val FILM = "film"
    }
}