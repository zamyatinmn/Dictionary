package com.geekbrains.dictionary.view.main

import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.repository.IRepository
import com.geekbrains.dictionary.presenter.IInteractor
import io.reactivex.Observable


class MainInteractor(
    private val remoteRepository: IRepository<List<DataModel>>,
    private val localRepository: IRepository<List<DataModel>>,
) : IInteractor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}