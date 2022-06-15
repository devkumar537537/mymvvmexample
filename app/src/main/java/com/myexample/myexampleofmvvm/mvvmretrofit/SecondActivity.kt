package com.myexample.myexampleofmvvm.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.myexample.myexampleofmvvm.QuoteApplicationClass
import com.myexample.myexampleofmvvm.R
import com.myexample.myexampleofmvvm.mvvmretrofit.factory.SecondViewModelFactory
import com.myexample.myexampleofmvvm.mvvmretrofit.repositry.QuoteRepostryRetrofit
import com.myexample.myexampleofmvvm.mvvmretrofit.services.QuoteServices
import com.myexample.myexampleofmvvm.mvvmretrofit.services.RetrofitHelper
import com.myexample.myexampleofmvvm.mvvmretrofit.viewmodels.SecondActivityViewModel

class SecondActivity : AppCompatActivity() {
    lateinit var secondviewModel: SecondActivityViewModel
    private  val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val repositry = (application as QuoteApplicationClass).quoteRepostryRetrofit
        secondviewModel = ViewModelProvider(this,SecondViewModelFactory(repositry)).get(SecondActivityViewModel::class.java)

       secondviewModel.quotes.observe(this, Observer {
           Log.d(TAG, "onCreate: ${it.results.size.toString()}")
       })
    }
}