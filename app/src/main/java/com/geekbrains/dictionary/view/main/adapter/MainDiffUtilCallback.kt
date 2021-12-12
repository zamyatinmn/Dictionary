package com.geekbrains.dictionary.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.geekbrains.dictionary.model.data.DataModel


class MainDiffUtilCallback(private val oldList: List<DataModel>, private val newList: List<DataModel>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldDataModel: DataModel = oldList[oldItemPosition]
        val newDataModel: DataModel = newList[newItemPosition]
        return oldDataModel.text == newDataModel.text
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldDataModel: DataModel = oldList[oldItemPosition]
        val newDataModel: DataModel = newList[newItemPosition]
        return oldDataModel == newDataModel
    }

}