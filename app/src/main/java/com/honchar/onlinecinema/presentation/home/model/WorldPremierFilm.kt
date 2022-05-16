package com.honchar.onlinecinema.presentation.home.model

data class WorldPremierFilm(
    val filmId: String,
    val filmName: String,
    val filmPoster: String,
    val filmRate: String,
    val filmRelease: String,
    val placeholder: Int,
    val isVisible: Boolean,
)