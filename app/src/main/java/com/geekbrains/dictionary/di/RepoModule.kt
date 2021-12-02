package com.geekbrains.dictionary.di

import com.geekbrains.dictionary.di.DiConstants.NAME_LOCAL
import com.geekbrains.dictionary.di.DiConstants.NAME_REMOTE
import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.datasource.DataSourceLocal
import com.geekbrains.dictionary.model.datasource.DataSourceRemote
import com.geekbrains.dictionary.model.datasource.RetrofitService
import com.geekbrains.dictionary.model.repository.IRepository
import com.geekbrains.dictionary.model.repository.Repository
import com.geekbrains.dictionary.presenter.IInteractor
import com.geekbrains.dictionary.rx.ISchedulerProvider
import com.geekbrains.dictionary.rx.SchedulerProvider
import com.geekbrains.dictionary.view.main.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class RepoModule {

    @Provides
    @Named(NAME_REMOTE)
    @Singleton
    fun provideRemoteRepository(retrofitService: RetrofitService): Repository {
        return Repository(DataSourceRemote(retrofitService))
    }

    @Provides
    @Named(NAME_LOCAL)
    @Singleton
    fun provideLocalRepository(): Repository {
        return Repository(DataSourceLocal())
    }

    @Provides
    fun provideMainInteractor(
        @Named(NAME_REMOTE) remoteRepository: Repository,
        @Named(NAME_LOCAL) localRepository: Repository,
    ): IInteractor<AppState> = MainInteractor(remoteRepository, localRepository)

    @Provides
    @Singleton
    fun provideSchedulerProvider(): ISchedulerProvider = SchedulerProvider()
}