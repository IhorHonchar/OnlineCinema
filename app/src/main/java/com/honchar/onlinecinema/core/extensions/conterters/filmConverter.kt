package com.honchar.onlinecinema.core.extensions.conterters

import com.honchar.onlinecinema.core.views.FilmsCategory
import com.honchar.onlinecinema.presentation.home.model.WorldPremierFilm

fun FilmsCategory.Film.toWorldPremier() =
    WorldPremierFilm(
        filmId = filmId,
        filmName = filmName,
        filmPoster = filmPoster,
        filmRate = filmRate,
        filmRelease = filmRelease,
        placeholder = placeholder,
        isVisible = false
    )