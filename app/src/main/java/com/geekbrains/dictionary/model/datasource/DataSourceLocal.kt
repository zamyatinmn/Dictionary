package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel

class DataSourceLocal(private val remoteProvider: RoomDataBase):
    IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)

    override suspend fun saveData(data: List<DataModel>) = remoteProvider.saveData(data)
}