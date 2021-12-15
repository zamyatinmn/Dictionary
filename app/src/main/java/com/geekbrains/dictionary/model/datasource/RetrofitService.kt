package com.geekbrains.dictionary.model.datasource

import android.util.Log
import com.geekbrains.dictionary.model.data.DataModel


class RetrofitService(private val apiService: ApiService) : IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return apiService.searchAsync(word).await()
    }

    override suspend fun saveData(data: List<DataModel>) {
        Log.e("RetrofitService", "remote data source cannot save data")
    }

}