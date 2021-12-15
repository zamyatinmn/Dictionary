package com.geekbrains.dictionary.model.datasource

import android.util.Log
import com.geekbrains.dictionary.model.data.DataModel


class DataSourceRemote(private val remoteProvider: RetrofitService) :
    IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
    override suspend fun saveData(data: List<DataModel>) {
        Log.e("DataSourceRemote", "remote data source cannot save data")
    }
}

