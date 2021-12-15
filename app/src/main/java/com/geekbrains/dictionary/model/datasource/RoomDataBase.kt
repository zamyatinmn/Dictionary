package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel


class RoomDataBase : IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return listOf(DataModel("Local database not implemented, sorry", null))
    }
}