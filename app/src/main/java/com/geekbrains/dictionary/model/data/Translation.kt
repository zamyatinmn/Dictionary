package com.geekbrains.dictionary.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

const val TEXT = "text"

@Parcelize
data class Translation(
    @SerializedName(TEXT)
    val translation: String?,
): Parcelable