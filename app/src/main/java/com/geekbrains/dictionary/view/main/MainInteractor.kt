package com.geekbrains.dictionary.view.main

import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.repository.IRepository
import com.geekbrains.dictionary.presenter.IInteractor


class MainInteractor(
    private val remoteRepository: IRepository<List<DataModel>>,
    private val localRepository: IRepository<List<DataModel>>,
) : IInteractor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource){
                val data = remoteRepository.getData(word)
                localRepository.saveData(data)
                data
            } else {
                localRepository.getData(word)
            }
        )
    }
}