package com.geekbrains.dictionary.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.model.data.DataModel


class MainAdapter(
    private var onListItemClickListener: OnListItemClickListener,
    private var data: List<DataModel>,
) :
    RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    fun setData(data: List<DataModel>) {
        val diffUtilCallback = MainDiffUtilCallback(this.data, data)
        val diffRes = DiffUtil.calculateDiff(diffUtilCallback)
        this.data = data
        diffRes.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        return RecyclerItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class RecyclerItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: DataModel) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                itemView.findViewById<TextView>(R.id.header_textview_recycler_item).text = data.text
                itemView.findViewById<TextView>(R.id.description_textview_recycler_item).text =
                    data.meanings?.get(0)?.translation?.translation
                itemView.setOnClickListener { openInNewWindow(data) }
            }
        }
    }

    private fun openInNewWindow(listItemData: DataModel) {
        onListItemClickListener.onItemClick(listItemData)
    }

    interface OnListItemClickListener {
        fun onItemClick(data: DataModel)
    }
}