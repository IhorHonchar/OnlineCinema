package com.honchar.onlinecinema.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.presentation.search.model.FilterItem
import com.honchar.onlinecinema.presentation.search.model.FindFilmModel

abstract class SearchViewModel: BaseViewModel() {
    abstract val filmsLiveData: LiveData<List<FindFilmModel>>
    abstract val filtersLiveData: LiveData<List<FilterItem>>

    abstract fun findFilm(search: String)
    abstract fun getFilters()
}

class SearchViewModelImpl: SearchViewModel() {


    override val filmsLiveData = MutableLiveData<List<FindFilmModel>>()
    override val filtersLiveData = MutableLiveData<List<FilterItem>>()

    override fun findFilm(search: String) {
        val film = FindFilmModel(
            id = "34567",
            name = "Some film",
            poster = "https://static.posters.cz/image/1300/%D0%9F%D0%BB%D0%B0%D0%BA%D0%B0%D1%82%D0%B8/fast-furious-dominic-toretto-i114155.jpg",
            rate = "4.1"
        )

        filmsLiveData.postValue(listOf(film, film, film, film, film, film, film, film, film, film, film, film, film, film))
    }

    override fun getFilters() {
        val filter = FilterItem(
            id ="",
            name = "Action"
        )
        filtersLiveData.postValue(
            listOf(
                filter,
                filter.copy(name = "+18"),
                filter.copy(name = "Drama"),
                filter.copy(name = "Commedi"),
                filter.copy(name = "+16"),
                filter,
                filter.copy(name = "+18"),
                filter.copy(name = "Drama"),
                filter.copy(name = "Commedi"),
                filter.copy(name = "+16")
            )
        )
    }

}