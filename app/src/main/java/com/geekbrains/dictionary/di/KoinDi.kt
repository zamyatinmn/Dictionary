package com.geekbrains.dictionary.di

import androidx.room.Room
import com.geekbrains.dictionary.Tools
import com.geekbrains.dictionary.di.DiConstants.BASE_URL
import com.geekbrains.dictionary.di.DiConstants.DATABASE_NAME
import com.geekbrains.dictionary.di.DiConstants.NAME_LOCAL
import com.geekbrains.dictionary.di.DiConstants.NAME_REMOTE
import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.database.AppDatabase
import com.geekbrains.dictionary.model.datasource.*
import com.geekbrains.dictionary.model.repository.IRepository
import com.geekbrains.dictionary.model.repository.Repository
import com.geekbrains.dictionary.presenter.IInteractor
import com.geekbrains.dictionary.rx.ISchedulerProvider
import com.geekbrains.dictionary.rx.SchedulerProvider
import com.geekbrains.dictionary.view.main.MainInteractor
import com.geekbrains.dictionary.view.main.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object KoinDi {
    val mainModule = module {
        viewModel { MainViewModel(interactor = get(), schedulerProvider = get()) }
    }

    val networkModule = module {
        single<Interceptor> { BaseInterceptor.interceptor }
        single<ApiService> { get<Retrofit>().create(ApiService::class.java) }
        single {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(interceptor = get())
            if (Tools.isDebug) {
                httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
            httpClient.build()
        }
        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(get())
                .build()
        }
    }

    val repoModule = module {
        single<ISchedulerProvider> { SchedulerProvider() }
        single { RetrofitService(apiService = get()) }
        single { RoomDataBase(dao = get()) }
        single<IRepository<List<DataModel>>>(named(NAME_LOCAL)) {
            Repository(DataSourceLocal(remoteProvider = get()))
        }
        single<IRepository<List<DataModel>>>(named(NAME_REMOTE)) {
            Repository(DataSourceRemote(remoteProvider = get()))
        }
        single<IInteractor<AppState>> {
            MainInteractor(
                remoteRepository = get(named(NAME_REMOTE)),
                localRepository = get(named(NAME_LOCAL))
            )
        }
    }

    val persistenceModule = module {
        single {
            Room.databaseBuilder(androidContext(), AppDatabase::class.java, DATABASE_NAME).build()
        }
        single {
            get<AppDatabase>().getDao()
        }
    }
}