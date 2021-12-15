package com.geekbrains.dictionary.model.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

const val TRANSLATION = "translation"
const val IMAGE_URL = "imageUrl"

@Parcelize
data class Meanings(
    @SerializedName(TRANSLATION)
    val translation: Translation?,
    @SerializedName(IMAGE_URL)
    val imageUrl: String?,
): Parcelable