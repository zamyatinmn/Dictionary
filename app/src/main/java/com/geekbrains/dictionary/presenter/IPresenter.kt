package com.geekbrains.dictionary.presenter

import com.geekbrains.dictionary.view.base.IView
import com.geekbrains.dictionary.model.data.AppState

interface IPresenter<T : AppState, V : IView> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}