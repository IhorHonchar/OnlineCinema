package com.honchar.onlinecinema.core.network

import com.google.gson.Gson
import com.honchar.onlinecinema.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface RetrofitFactory {

    fun createRetrofit(gson: Gson): Retrofit
}

class RetrofitFactoryImpl(
    private val okHttpClient: OkHttpClient,
): RetrofitFactory {

    override fun createRetrofit(gson: Gson): Retrofit {

        val okHttpBuilder = okHttpClient.newBuilder()

        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        okHttpBuilder.addInterceptor(loggingInterceptor)

        okHttpBuilder
            .connectTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)

        var builder: Retrofit.Builder = Retrofit.Builder()

//        builder.baseUrl(BuildConfig.API_URL)

        builder = builder.client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))

        return builder.build()
    }

    companion object {
        private const val TIMEOUT_SECS: Long = 60
    }

}