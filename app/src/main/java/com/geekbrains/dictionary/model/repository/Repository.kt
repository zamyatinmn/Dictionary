package com.geekbrains.dictionary.model.repository

import com.geekbrains.dictionary.model.datasource.IDataSource
import com.geekbrains.dictionary.model.data.DataModel
import io.reactivex.Observable


class Repository(private val dataSource: IDataSource<List<DataModel>>) :
    IRepository<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}