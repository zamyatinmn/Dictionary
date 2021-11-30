package com.geekbrains.dictionary.view.main

import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.model.datasource.DataSourceLocal
import com.geekbrains.dictionary.model.datasource.DataSourceRemote
import com.geekbrains.dictionary.model.repository.Repository
import com.geekbrains.dictionary.presenter.IPresenter
import com.geekbrains.dictionary.rx.ISchedulerProvider
import com.geekbrains.dictionary.rx.SchedulerProvider
import com.geekbrains.dictionary.view.base.IView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver


class MainPresenter<T : AppState, V : IView>(
    private val interactor: MainInteractor,
    private val compositeDisposable: CompositeDisposable,
    private val schedulerProvider: ISchedulerProvider,
) : IPresenter<T, V> {

    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io)
                .observeOn(schedulerProvider.ui)
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}