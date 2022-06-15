package com.myexample.myexampleofmvvm.mvvmretrofit.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val url = "https://quotable.io/"

    fun getinstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}