package com.honchar.onlinecinema.data.model.request

import com.google.gson.annotations.SerializedName

data class FilmRequestModel(
    @SerializedName("film_id")
    val filmId: Int
)