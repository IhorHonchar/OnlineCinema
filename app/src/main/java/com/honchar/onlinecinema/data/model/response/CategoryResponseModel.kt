package com.honchar.onlinecinema.data.model.response

import com.google.gson.annotations.SerializedName

data class CategoryResponseModel(
    @SerializedName("category_id")
    val categoryId: Int?,
    @SerializedName("category_name")
    val categoryName: String?,
    @SerializedName("category_films")
    val categoryFilms: List<FilmResponseModel>
)