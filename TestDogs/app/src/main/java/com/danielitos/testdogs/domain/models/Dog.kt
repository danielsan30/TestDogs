package com.danielitos.testdogs.domain.models

import com.danielitos.testdogs.data.databbase.entity.DogEntity
import com.danielitos.testdogs.data.rest.responses.DogResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by danielsanchez on 22/12/24
 */

data class Dog(
    @SerializedName("dogName") val dogName: String,
    @SerializedName("age") val age: Int,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)


fun DogResponse.toDomain() = Dog(dogName,age,description,image)
fun DogEntity.toDomain() = Dog(dogName,age,description,image)