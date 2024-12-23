package com.danielitos.testdogs.data.databbase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danielitos.testdogs.data.databbase.entity.DogEntity

/**
 * Created by danielsanchez on 22/12/24
 */

@Dao
interface DogDao {

    @Query("SELECT * FROM dogs_table ORDER BY id ASC")
    suspend fun getAllDogs():List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDogs(quotes:List<DogEntity>)

    @Query("DELETE FROM dogs_table")
    suspend fun deleteAllDogs()
}