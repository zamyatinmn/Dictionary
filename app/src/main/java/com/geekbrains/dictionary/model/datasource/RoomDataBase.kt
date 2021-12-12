package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel
import io.reactivex.Observable


class RoomDataBase : IDataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return Observable.just(listOf(DataModel("Local database not implemented, sorry", null)))
    }
}