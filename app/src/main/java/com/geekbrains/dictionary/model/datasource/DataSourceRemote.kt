package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel
import io.reactivex.Observable


class DataSourceRemote(private val remoteProvider: RetrofitService) :
    IDataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}

