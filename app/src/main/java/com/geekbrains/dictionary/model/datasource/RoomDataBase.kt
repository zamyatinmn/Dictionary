package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.database.DataModelDao


class RoomDataBase(private val dao: DataModelDao) : IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return if (word.isEmpty()) dao.getAll() else dao.getAllByQuery(word)
    }

    override suspend fun saveData(data: List<DataModel>) {
        dao.insertAll(data)
    }
}