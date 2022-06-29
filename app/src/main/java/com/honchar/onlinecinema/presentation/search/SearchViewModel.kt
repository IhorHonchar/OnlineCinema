package com.honchar.onlinecinema.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.honchar.onlinecinema.core.base.presentation.BaseViewModel
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.filmDetails.model.CategoryModel

abstract class SearchViewModel: BaseViewModel() {
    abstract val filmsLiveData: LiveData<List<FilmsCategory.Film>>
    abstract val filtersLiveData: LiveData<List<CategoryModel>>

    abstract fun findFilm(search: String?)
    abstract fun findByFilters(filters: List<CategoryModel>)
    abstract fun getFilters()
}

class SearchViewModelImpl: SearchViewModel() {


    override val filmsLiveData = MutableLiveData<List<FilmsCategory.Film>>()
    override val filtersLiveData = MutableLiveData<List<CategoryModel>>()

    override fun findFilm(search: String?) {
        search?.let { s ->
            filmsLiveData.postValue(FilmsFactory.getFilms().filter { it.filmName.contains(s,true) })
        } ?: filmsLiveData.postValue(FilmsFactory.getFilms())
    }

    override fun findByFilters(filters: List<CategoryModel>) {
        val res = mutableListOf<FilmsCategory.Film>()
        filters.forEach { category ->
            FilmsFactory.getFilms().filter { film ->
                film.categories.find { it.id == category.id } != null
            }.let { list ->
                list.filter { !res.contains(it) }
            }.let {
                res.addAll(it)
            }
        }
        filmsLiveData.postValue(res)
    }

    override fun getFilters() {
        filtersLiveData.postValue(FilmsFactory.getCategories())
    }

}