package com.geekbrains.dictionary.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.model.datasource.DataSourceLocal
import com.geekbrains.dictionary.model.datasource.DataSourceRemote
import com.geekbrains.dictionary.model.repository.Repository
import com.geekbrains.dictionary.rx.SchedulerProvider
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject


class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        Repository(DataSourceRemote()),
        Repository(DataSourceLocal())
    ),
    schedulerProvider: SchedulerProvider = SchedulerProvider(),
) : ViewModel() {

    private val subjectLoading = BehaviorSubject.create<Unit>()
    private val subjectRequest = BehaviorSubject.create<Pair<String, Boolean>>()

    private val observableResponse = subjectRequest
        .doOnNext { subjectLoading.onNext(Unit) }
        .flatMap {
            interactor.getData(it.first, it.second)
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
        }


    fun getData(word: String, isOnline: Boolean) {
        subjectRequest.onNext(Pair(word, isOnline))
    }

    private val screenState = Observable.merge(listOf(
        subjectLoading.map { AppState.Loading(null) },
        observableResponse.doOnError { AppState.Error(it) }
    ))

    private val liveDataObserver =
        LiveDataReactiveStreams.fromPublisher(screenState.toFlowable(BackpressureStrategy.LATEST))

    fun getLiveData(): LiveData<AppState> = liveDataObserver
}