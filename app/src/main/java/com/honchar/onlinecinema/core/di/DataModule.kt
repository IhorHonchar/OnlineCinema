package com.honchar.onlinecinema.core.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.honchar.onlinecinema.data.api.CinemaApi
import com.honchar.onlinecinema.core.network.RetrofitFactory
import com.honchar.onlinecinema.core.network.RetrofitFactoryImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {

    single { OkHttpClient() }
    single<Gson> { GsonBuilder().setLenient().create() }
    single<RetrofitFactory> { RetrofitFactoryImpl(get()) }
    single<Retrofit> { get<RetrofitFactory>().createRetrofit(get()) }
    single { get<Retrofit>().create(CinemaApi::class.java) }
}