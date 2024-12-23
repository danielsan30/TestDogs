package com.danielitos.testdogs.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.danielitos.testdogs.utils.AppConstants.TAG
import com.danielitos.testdogs.domain.GetDogsUseCase
import com.danielitos.testdogs.domain.models.Dog
import kotlinx.coroutines.launch

class SplashViewModel(context: Context) : ViewModel() {
    val dogList = MutableLiveData<List<Dog>>()
    val error = MutableLiveData<String>()
    var getDogsUseCase = GetDogsUseCase(context)

    fun getnVerifyDogs() {
        viewModelScope.launch {
            var result = getDogsUseCase.getnVerifyDogs()

            result?.let {
                it.onSuccess {
                    error.postValue("")
                    dogList.postValue(it)
                }.onFailure {
                    Log.i(TAG, "ERROR $it")
                    error.postValue(it.message)
                }
            }
        }
    }
}

class SplashViewModelFactory(private  val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(context) as T
    }
}