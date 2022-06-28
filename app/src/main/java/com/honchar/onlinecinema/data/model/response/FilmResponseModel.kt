package com.honchar.onlinecinema.data.model.response

import com.google.gson.annotations.SerializedName

data class FilmResponseModel(
    @SerializedName("film_id")
    val filmId: Int?,
    @SerializedName("film_name")
    val filmName: String?,
    @SerializedName("film_desc")
    val filmDesc: String?,
    @SerializedName("film_rate")
    val filmRate: String?,
    @SerializedName("poster_url")
    val posterUrl: String?
)
