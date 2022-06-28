package com.honchar.onlinecinema.data.api

import com.honchar.onlinecinema.data.model.response.HomePageResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CinemaApi {

    @GET("homePage")
    fun getHomePageData(): Response<HomePageResponseModel>

    @POST("getFilm")
    fun getFilm(@Body body: Any): Response<Any>

    @POST("getFilms")
    fun getFilms(@Body body: Any): Response<Any>

    @POST("getWishList")
    fun getWishList(@Body body: Any): Response<Any>

    @POST("getFavorites")
    fun getFavorites(@Body body: Any): Response<Any>

    @GET("getAllCategories")
    fun getAllCategories(): Response<Any>
}