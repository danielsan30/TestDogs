package com.danielitos.testdogs.domain

import android.content.Context
import android.util.Log
import com.danielitos.testdogs.utils.AppConstants.TAG
import com.danielitos.testdogs.data.GetDogsRepository
import com.danielitos.testdogs.data.databbase.entity.toDatabase
import com.danielitos.testdogs.domain.models.Dog
import com.danielitos.testdogs.domain.models.toDomain

/**
 * Created by danielsanchez on 20/12/24
 */
class GetDogsUseCase(context: Context) {
    private val repository = GetDogsRepository(context)

    suspend  fun getnVerifyDogs() : Result<List<Dog>>? {
        repository.getAllDogsFromDB().onSuccess {list ->
            Log.i(TAG,"===dataFromDB === $list")
            return Result.success(list.map { it.toDomain() })
        }.onFailure {
            Log.i(TAG,"===getDataFromApi === ")
            repository.getAllDogsFromApi().onSuccess { list ->
                Log.i(TAG,"===dataFromAPI === $list")
                repository.saveDogsInDB(list.map { it.toDatabase() })
                return Result.success(list.map { it.toDomain() })
            }.onFailure {restFail ->
                Log.i(TAG,"errorGettingData === $restFail")
                return  Result.failure(restFail)
            }
        }
        return null
    }

    suspend  fun getDogsForList() : List<Dog>? {
        repository.getAllDogsFromDB().onSuccess { list ->
            return list.map { it.toDomain() }
        }.onFailure {
            return null
        }
        return null
    }
}