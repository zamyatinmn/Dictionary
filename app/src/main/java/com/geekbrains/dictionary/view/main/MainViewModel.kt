package com.geekbrains.dictionary.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.presenter.IInteractor
import com.geekbrains.dictionary.rx.ISchedulerProvider
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject


class MainViewModel : ViewModel() {

    @Inject
    lateinit var interactor: IInteractor<AppState>

    @Inject
    lateinit var schedulerProvider: ISchedulerProvider

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