package com.geekbrains.dictionary.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.dictionary.model.data.AppState
import com.geekbrains.dictionary.presenter.IPresenter


abstract class BaseActivity<T : AppState> : AppCompatActivity(), IView {

    protected lateinit var presenter: IPresenter<T, IView>

    protected abstract fun createPresenter(): IPresenter<T, IView>

    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }

}