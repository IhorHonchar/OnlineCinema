package com.honchar.onlinecinema.presentation.filmDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.media3.exoplayer.ExoPlayer
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.presentation.filmDetails.model.ActorModel
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel
import com.honchar.onlinecinema.presentation.filmDetails.model.FilmDetailsModel

abstract class FilmDetailsViewModel: BaseViewModel() {
    abstract val filmDetails: LiveData<FilmDetailsModel>
    abstract val playerLiveData: LiveData<ExoPlayer>

    abstract fun getFilm(filmId: String)
    abstract fun savePlayer(player: ExoPlayer)
}

class FilmDetailsViewModelImpl: FilmDetailsViewModel() {

    override val filmDetails = MutableLiveData<FilmDetailsModel>()
    override val playerLiveData = MutableLiveData<ExoPlayer>()

    override fun getFilm(filmId: String) {
    }

    override fun savePlayer(player: ExoPlayer) {
        playerLiveData.postValue(player)
    }

}