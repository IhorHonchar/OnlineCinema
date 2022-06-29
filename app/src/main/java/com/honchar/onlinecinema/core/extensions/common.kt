package com.honchar.onlinecinema.core.extensions

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.presentation.filmDetails.FilmDetailsActivity

fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?) {
    if (p1 != null && p2 != null) block.invoke(p1, p2)
}

fun Fragment.openFilm(film: FilmsCategory.Film){
    startActivity(Intent(requireContext(), FilmDetailsActivity::class.java).apply {
        putExtra(FilmDetailsActivity.FILM, film)
    })
}

fun Activity.openFilm(film: FilmsCategory.Film){
    startActivity(Intent(this, FilmDetailsActivity::class.java).apply {
        putExtra(FilmDetailsActivity.FILM, film)
    })
}