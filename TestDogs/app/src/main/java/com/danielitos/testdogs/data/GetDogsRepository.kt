package com.danielitos.testdogs.data

import android.content.Context
import android.util.Log
import com.danielitos.testdogs.utils.AppConstants.TAG
import com.danielitos.testdogs.data.databbase.DogDB
import com.danielitos.testdogs.data.databbase.entity.DogEntity
import com.danielitos.testdogs.data.rest.responses.DogResponse
import com.danielitos.testdogs.data.rest.services.GetDogsService


/**
 * Created by danielsanchez on 20/12/24
 */
class GetDogsRepository(ctx: Context) {
    private val api = GetDogsService()
    val db = DogDB.getDatabase(ctx)
    val dogDao = db.getDogDao()

    suspend fun getAllDogsFromApi(): Result<List<DogResponse>> {
        val response = api.getDogsList()
        return response
    }

    suspend fun getAllDogsFromDB(): Result<List<DogEntity>> {
        val dogsList = dogDao.getAllDogs()
        if(dogsList.isEmpty()){
            Log.i(TAG, "No hay datos en db")
            return Result.failure(Exception("No hay datos en db"))
        } else
            return Result.success(dogsList)
    }

    suspend fun saveDogsInDB(list: List<DogEntity>){
        dogDao.deleteAllDogs()
        dogDao.insertAllDogs(list)

        val alldogs =  dogDao.getAllDogs()
        alldogs.forEach{
            Log.i(TAG, "DOGFROMDB -> ${it.toString()}")
        }
    }
}