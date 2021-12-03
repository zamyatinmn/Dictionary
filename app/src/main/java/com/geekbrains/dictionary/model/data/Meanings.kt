package com.geekbrains.dictionary.model.data

import com.google.gson.annotations.SerializedName

const val TRANSLATION = "translation"
const val IMAGE_URL = "imageUrl"

data class Meanings(
    @SerializedName(TRANSLATION)
    val translation: Translation?,
    @SerializedName(IMAGE_URL)
    val imageUrl: String?,
)