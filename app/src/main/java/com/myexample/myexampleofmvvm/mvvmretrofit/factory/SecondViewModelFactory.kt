package com.myexample.myexampleofmvvm.mvvmretrofit.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myexample.myexampleofmvvm.mvvmretrofit.repositry.QuoteRepostryRetrofit
import com.myexample.myexampleofmvvm.mvvmretrofit.viewmodels.SecondActivityViewModel

class SecondViewModelFactory(private val quoteRepostryRetrofit: QuoteRepostryRetrofit): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondActivityViewModel(quoteRepostryRetrofit) as T
    }
}