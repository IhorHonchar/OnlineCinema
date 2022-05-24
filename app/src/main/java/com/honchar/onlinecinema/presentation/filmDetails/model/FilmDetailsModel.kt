package com.honchar.onlinecinema.presentation.filmDetails.model

data class FilmDetailsModel(
    val name: String,
    val poster: String,
    val videoUrl: String,
    val description: String,
    val isFavorite: Boolean,
    val categories: List<CategoryModel>,
    val actors: List<ActorModel>
)
