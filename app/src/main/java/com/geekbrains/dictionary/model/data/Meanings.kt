package com.geekbrains.dictionary.model.data

import com.google.gson.annotations.SerializedName

class Meanings(
    @SerializedName("translation")
    val translation: Translation?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
)