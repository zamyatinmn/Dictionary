package com.geekbrains.dictionary.presenter

interface IInteractor<T> {
    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}