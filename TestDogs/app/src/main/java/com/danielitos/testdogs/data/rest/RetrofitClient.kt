package com.danielitos.testdogs.data.rest
import com.danielitos.testdogs.utils.AppConstants.BASEURL
import com.danielitos.testdogs.data.rest.apis.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * Created by danielsanchez on 20/12/24
 */


object RetrofitClient {
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}