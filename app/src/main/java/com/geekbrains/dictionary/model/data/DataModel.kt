package com.geekbrains.dictionary.model.data

import com.google.gson.annotations.SerializedName

const val TEXT_NAME = "text"
const val MEANINGS_NAME = "meanings"

data class DataModel(
    @SerializedName(TEXT_NAME)
    val text: String?,
    @SerializedName(MEANINGS_NAME)
    val meanings: List<Meanings>?,
)