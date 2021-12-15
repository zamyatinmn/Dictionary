package com.geekbrains.dictionary.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geekbrains.dictionary.model.data.DataModel

@Dao
interface DataModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<DataModel>)

    @Query("SELECT * FROM datamodel WHERE text = :query")
    suspend fun getAllByQuery(query: String): List<DataModel>
}