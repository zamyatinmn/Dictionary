package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel


class DataSourceRemote(private val remoteProvider: RetrofitService) :
    IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}

