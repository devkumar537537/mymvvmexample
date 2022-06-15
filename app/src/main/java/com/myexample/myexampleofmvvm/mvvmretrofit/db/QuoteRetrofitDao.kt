package com.myexample.myexampleofmvvm.mvvmretrofit.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.myexample.myexampleofmvvm.mvvmretrofit.models.Result

@Dao
interface QuoteRetrofitDao {
    
    
    @Insert
    suspend fun insert(quotes: List<Result>)
    
    @Query("SELECT * FROM quotes")
    suspend fun getquotlistfromdatabase():List<Result>
}