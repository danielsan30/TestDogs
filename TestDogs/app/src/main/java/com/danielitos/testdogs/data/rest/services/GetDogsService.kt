package com.danielitos.testdogs.data.rest.services

import com.danielitos.testdogs.data.rest.ApiClient
import com.danielitos.testdogs.data.rest.responses.DogResponse
import java.net.UnknownHostException


/**
 * Created by danielsanchez on 20/12/24
 */
class GetDogsService {
    suspend fun getDogsList(): Result<List<DogResponse>> {
        return try {
            val response = ApiClient.apiService.getAllDogs()

            if(response.isSuccessful){
                Result.success(response.body() ?: arrayListOf())
            }else{
                Result.failure(Exception("${response.code()}  ${response.message()}"))
            }
        }catch (e: UnknownHostException) {
            Result.failure(Exception("No hay internet"))
        }catch (e:Exception){
            Result.failure(Exception("${e.message}"))
        }
    }
}
