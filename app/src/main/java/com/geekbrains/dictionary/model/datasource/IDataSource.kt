package com.geekbrains.dictionary.model.datasource

interface IDataSource<T> {

    suspend fun getData(word: String): T
    suspend fun saveData(data: T)
}