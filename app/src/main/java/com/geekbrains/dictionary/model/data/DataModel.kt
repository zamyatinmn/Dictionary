package com.geekbrains.dictionary.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

const val TEXT_NAME = "text"
const val MEANINGS_NAME = "meanings"

@Parcelize
data class DataModel(
    @SerializedName(TEXT_NAME)
    val text: String?,
    @SerializedName(MEANINGS_NAME)
    val meanings: List<Meanings>?,
): Parcelable