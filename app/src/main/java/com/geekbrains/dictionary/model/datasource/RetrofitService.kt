package com.geekbrains.dictionary.model.datasource

import com.geekbrains.dictionary.model.data.DataModel
import io.reactivex.Observable
import javax.inject.Inject


class RetrofitService @Inject constructor(
    private val apiService: ApiService,
) : IDataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return apiService.search(word)
    }

}