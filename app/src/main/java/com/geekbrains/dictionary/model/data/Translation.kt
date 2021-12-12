package com.geekbrains.dictionary.model.data

import com.google.gson.annotations.SerializedName

const val TEXT = "text"

data class Translation(
    @SerializedName(TEXT)
    val translation: String?,
)