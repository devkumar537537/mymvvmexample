package com.myexample.myexampleofmvvm.mvvmretrofit.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myexample.myexampleofmvvm.mvvmretrofit.models.QuoteList
import com.myexample.myexampleofmvvm.mvvmretrofit.repositry.QuoteRepostryRetrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondActivityViewModel(private val quoteRepostryRetrofit: QuoteRepostryRetrofit) :ViewModel(){
    init {
        viewModelScope.launch(Dispatchers.IO){
            quoteRepostryRetrofit.getquotlist(1)
        }
    }

    val quotes:LiveData<QuoteList>
    get() = quoteRepostryRetrofit.quotes
}