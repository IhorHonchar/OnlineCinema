package com.honchar.onlinecinema.presentation.films

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.honchar.onlinecinema.core.base.adapter.BaseViewBindingAdapter
import com.honchar.onlinecinema.core.extensions.openFilm
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.databinding.ActivityFilmsBinding
import com.honchar.onlinecinema.databinding.SearchHorizontalItemBinding
import com.honchar.onlinecinema.presentation.FilmsFactory
import com.honchar.onlinecinema.presentation.films.adapter.FilmHolder

class FilmsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFilmsBinding

    val adapter = BaseViewBindingAdapter()
        .map(
            SearchHorizontalItemBinding::inflate,
            FilmHolder(::openFilm)
        )

    private val films: ArrayList<FilmsCategory.Film>?
    get() = intent?.getParcelableArrayListExtra(FILMS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvFilms.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        films?.let {
            adapter.loadItems(it)
        }
    }

    companion object {
        const val FILMS = "films"
    }

}