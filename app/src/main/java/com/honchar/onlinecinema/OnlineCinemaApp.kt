package com.honchar.onlinecinema

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.honchar.onlinecinema.core.di.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class OnlineCinemaApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            if (BuildConfig.DEBUG)
                androidLogger()

            androidContext(this@OnlineCinemaApp)
            modules(
                viewModel,
            )
        }

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}