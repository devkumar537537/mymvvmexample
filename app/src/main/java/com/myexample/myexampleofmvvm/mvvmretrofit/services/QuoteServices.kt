package com.myexample.myexampleofmvvm.mvvmretrofit.services

import com.myexample.myexampleofmvvm.mvvmretrofit.models.QuoteList
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteServices {

    @GET("quotes")
 suspend fun getquotlist(@Query("page") page:Int): Response<QuoteList>

}