package com.geekbrains.dictionary.di

import com.geekbrains.dictionary.view.main.MainActivity
import com.geekbrains.dictionary.view.main.MainViewModel
import com.geekbrains.dictionary.view.main.adapter.MainAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    RepoModule::class
])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainViewModel: MainViewModel)
    fun inject(mainAdapter: MainAdapter)
}