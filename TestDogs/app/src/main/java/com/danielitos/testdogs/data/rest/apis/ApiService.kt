package com.danielitos.testdogs.data.rest.apis
import com.danielitos.testdogs.data.rest.responses.DogResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by danielsanchez on 20/12/24
 */


interface ApiService {
    @GET("api/1151549092634943488")
    suspend fun getAllDogs(): Response<List<DogResponse>>
}