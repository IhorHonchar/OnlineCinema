package com.honchar.onlinecinema.presentation.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.core.views.FilmsCategory.FilmCategory
import com.honchar.onlinecinema.presentation.FilmsFactory

abstract class HomeViewModel: BaseViewModel(){
    abstract val itemsLiveData: LiveData<List<FilmCategory>>
    abstract val topFilmsLiveData: LiveData<List<FilmsCategory.Film>>

    abstract fun getItems()
}

class HomeViewModelImpl : HomeViewModel() {
    override val itemsLiveData = MutableLiveData<List<FilmCategory>>()
    override val topFilmsLiveData = MutableLiveData<List<FilmsCategory.Film>>()


    override fun getItems() {
        val list = listOf(
            FilmCategory(
                filmCategoryTitle = "Popular films",
                films = FilmsFactory.getFilms()
            ),
            FilmCategory(
                filmCategoryTitle = "Most Popular films",
                films = FilmsFactory.getFilms()
            ),
            FilmCategory(
                filmCategoryTitle = "Best films",
                films = FilmsFactory.getFilms()
            )
        )
        itemsLiveData.postValue(list)
        topFilmsLiveData.postValue(FilmsFactory.getFilms())
    }
}