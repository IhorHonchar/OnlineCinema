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
        val category = CategoryModel(
            id = "1234",
            name = "Action"
        )
        val actor = ActorModel(
            id = "6543",
            name = "Tom Hardy",
            photo = "https://upload.wikimedia.org/wikipedia/commons/7/73/Tom_Hardy_Cannes_2015.jpg"
        )
        val film = FilmDetailsModel(
            name = "Venom",
            poster = "https://content2.rozetka.com.ua/goods/images/big/19479139.jpg",
            videoUrl = "https://www.nusenglish.com/wp-content/uploads/2022/05/videoplayback.mp4",
            description = "A failed reporter is bonded to an alien entity, one of many symbiotes who have invaded Earth. But the being takes a liking to Earth and decides to protect it.",
            isFavorite = true,
            categories = listOf(category, category.copy(name = "Comedi"), category.copy(name = "+16"), category, category.copy(name = "Comedi"), category.copy(name = "+16")),
            actors = listOf(actor, actor, actor, actor, actor, actor)
        )
        filmDetails.postValue(film)
    }

    override fun savePlayer(player: ExoPlayer) {
        playerLiveData.postValue(player)
    }

}