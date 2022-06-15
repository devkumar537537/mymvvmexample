package com.myexample.myexampleofmvvm.mvvmretrofit.repositry

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.myexample.myexampleofmvvm.mvvmretrofit.db.QuoteDatabaseClass
import com.myexample.myexampleofmvvm.mvvmretrofit.models.QuoteList
import com.myexample.myexampleofmvvm.mvvmretrofit.services.QuoteServices
import com.myexample.myexampleofmvvm.utilispackage.MyCommonFunctions

class QuoteRepostryRetrofit(private val quoteServices: QuoteServices,private val quoteDatabaseClass: QuoteDatabaseClass,private val context:Context) {
    private val quotelivedata = MutableLiveData<QuoteList>()

    val quotes :LiveData<QuoteList>
    get() = quotelivedata


    suspend fun getquotlist(page:Int)
    {

    if(MyCommonFunctions.isInterntAvailgle(context)){
        val restul = quoteServices.getquotlist(page)
        if(restul.body() != null)
        {
            quoteDatabaseClass.quoteDao().insert(restul.body()!!.results)
            quotelivedata.postValue(restul.body())
        }
    }else{
        val quotes = quoteDatabaseClass.quoteDao().getquotlistfromdatabase()
        val quotelist = QuoteList(1,1,1,quotes,1,1)
        quotelivedata.postValue(quotelist)
    }
    }

    suspend fun getquotinbackground(){
        val randorniumber = (Math.random() * 10).toInt()
        val result = quoteServices.getquotlist(randorniumber)
            if(result.body() != null)
            {
                quoteDatabaseClass.quoteDao().insert(result.body()!!.results)
            }
    }

}