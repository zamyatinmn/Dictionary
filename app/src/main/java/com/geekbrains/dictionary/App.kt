package com.geekbrains.dictionary

import android.app.Application
import com.geekbrains.dictionary.di.AppComponent
import com.geekbrains.dictionary.di.DaggerAppComponent


class App: Application() {
    companion object{
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().build()
    }
}