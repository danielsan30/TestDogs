package com.danielitos.testdogs.data.databbase

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.danielitos.testdogs.data.databbase.dao.DogDao
import com.danielitos.testdogs.data.databbase.entity.DogEntity

/**
 * Created by danielsanchez on 22/12/24
 */
@Database(entities = [DogEntity::class], version = 1)
abstract class DogDB: RoomDatabase() {

    abstract fun getDogDao():DogDao

    companion object {
        @Volatile private var instance: DogDB? = null

        fun getDatabase(context: android.content.Context): DogDB =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: android.content.Context) =
            Room.databaseBuilder(context.applicationContext, DogDB::class.java, "AppDatabase").build()
    }
}