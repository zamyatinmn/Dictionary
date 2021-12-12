package com.geekbrains.dictionary

import android.app.Application
import com.geekbrains.dictionary.di.KoinDi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App: Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@App)
            modules(
                KoinDi.mainModule,
                KoinDi.networkModule,
                KoinDi.repoModule
            )
        }
    }
}