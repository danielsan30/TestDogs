package com.danielitos.testdogs.data.databbase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danielitos.testdogs.data.rest.responses.DogResponse
import com.danielitos.testdogs.domain.models.Dog

/**
 * Created by danielsanchez on 22/12/24
 */

@Entity(tableName = "dogs_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id: Int = 0,
    @ColumnInfo("dogName") val dogName: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("image") val image: String,
    @ColumnInfo("age") val age: Int
)

fun Dog.toDatabase() = DogEntity(dogName = dogName, description = description, image = image, age = age)
fun DogResponse.toDatabase() = DogEntity(dogName = dogName, description = description, image = image, age = age)