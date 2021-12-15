package com.geekbrains.dictionary.model.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

const val TEXT_NAME = "text"
const val MEANINGS_NAME = "meanings"

@Parcelize
@Entity
data class DataModel(
    @SerializedName(TEXT_NAME)
    @PrimaryKey
    val text: String = "",
    @SerializedName(MEANINGS_NAME)
    val meanings: List<Meanings>?,
): Parcelable