package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel


class RetrofitService(private val apiService: ApiService) : IDataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return apiService.searchAsync(word).await()
    }

}