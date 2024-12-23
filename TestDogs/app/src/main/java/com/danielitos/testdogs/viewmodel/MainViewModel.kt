package com.danielitos.testdogs.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.danielitos.testdogs.domain.GetDogsUseCase
import com.danielitos.testdogs.domain.models.Dog
import kotlinx.coroutines.launch

class MainViewModel(context: Context) : ViewModel() {
    val dogList = MutableLiveData<List<Dog>>()
    var getDogsUseCase = GetDogsUseCase(context)

    fun getDogsForList() {
        viewModelScope.launch {
            var dogsList = getDogsUseCase.getDogsForList()

            dogsList?.let {list->
                dogList.postValue(list)
            } ?: dogList.postValue(arrayListOf())
        }
    }
}

class MainViewModelFactory(private  val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(context) as T
    }
}