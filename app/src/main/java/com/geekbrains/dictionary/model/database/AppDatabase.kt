package com.geekbrains.dictionary.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.geekbrains.dictionary.model.data.DataModel
import com.geekbrains.dictionary.model.database.converters.MeaningsConverter
import com.geekbrains.dictionary.model.database.converters.TranslationConverter


@Database(entities = [DataModel::class], version = 1, exportSchema = true)
@TypeConverters(MeaningsConverter::class, TranslationConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): DataModelDao
}