package com.geekbrains.dictionary.model.database.converters

import androidx.room.TypeConverter
import com.geekbrains.dictionary.model.data.Translation

object TranslationConverter {
    @TypeConverter
    fun fromString(value: String): Translation {
        return Translation(value)
    }

    @TypeConverter
    fun fromArrayList(translation: Translation): String {
        return translation.translation ?: ""
    }
}