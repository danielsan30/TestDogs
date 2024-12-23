package com.danielitos.testdogs.data.rest.responses

import com.danielitos.testdogs.data.databbase.entity.DogEntity
import com.danielitos.testdogs.domain.models.Dog
import com.google.gson.annotations.SerializedName

/**
 * Created by danielsanchez on 20/12/24
 */
data class DogResponse(
    @SerializedName("dogName") val dogName: String,
    @SerializedName("age") val age: Int,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
)


