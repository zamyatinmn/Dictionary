package com.geekbrains.dictionary.view.base

import com.geekbrains.dictionary.model.data.AppState


interface IView {
    fun renderData(appState: AppState)
}