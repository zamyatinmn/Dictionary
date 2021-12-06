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
import kotlinx.coroutines.*


class MainViewModel(
    private val interactor: IInteractor<AppState>,
    private val schedulerProvider: ISchedulerProvider,
): ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)
    private var job: Job? = null

    private val subjectLoading = BehaviorSubject.create<Unit>()
    private val subjectResult = BehaviorSubject.create<AppState>()
    private val observableResponse = subjectResult.doOnNext { subjectLoading.onNext(Unit) }
    private val screenState = Observable.merge(listOf(
        subjectLoading.map { AppState.Loading(null) },
        observableResponse.doOnError { AppState.Error(it) }
    ))
    private val liveDataObserver =
        LiveDataReactiveStreams.fromPublisher(screenState.toFlowable(BackpressureStrategy.LATEST))

    private fun startInteraction(word: String, isOnline: Boolean) {
        job?.cancel()
        var result: AppState
        job = scope.launch {
            result = interactor.getData(word, isOnline)
            subjectResult.onNext(result)
        }
    }

    fun getData(word: String, isOnline: Boolean) {
        startInteraction(word, isOnline)
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

    fun getLiveData(): LiveData<AppState> = liveDataObserver
}