package com.geekbrains.dictionary.model.database.converters

import androidx.room.TypeConverter
import com.geekbrains.dictionary.model.data.Meanings
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object MeaningsConverter {
    @TypeConverter
    fun fromString(value: String): List<Meanings> {
        val listType: Type = object: TypeToken<List<Meanings>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: List<Meanings>): String {
        return Gson().toJson(list)
    }
}