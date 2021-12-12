package com.geekbrains.dictionary.model.repository

import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.datasource.IDataSource


class Repository(private val dataSource: IDataSource<List<DataModel>>) :
    IRepository<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}