package com.honchar.onlinecinema.data.model.response

import com.google.gson.annotations.SerializedName

data class HomePageResponseModel(
    @SerializedName("top_films_title")
    val title: String,
    @SerializedName("top_films")
    val films: List<FilmResponseModel>,
    @SerializedName("films_categories")
    val categories: List<CategoryResponseModel>
)
