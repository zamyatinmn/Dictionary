package com.geekbrains.dictionary.model.repository

interface IRepository<T> {

    suspend fun getData(word: String): T
}