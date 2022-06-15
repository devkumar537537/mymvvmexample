package com.myexample.myexampleofmvvm

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.myexample.myexampleofmvvm.mvvmretrofit.db.QuoteDatabaseClass
import com.myexample.myexampleofmvvm.mvvmretrofit.repositry.QuoteRepostryRetrofit
import com.myexample.myexampleofmvvm.mvvmretrofit.services.QuoteServices
import com.myexample.myexampleofmvvm.mvvmretrofit.services.RetrofitHelper
import com.myexample.myexampleofmvvm.mvvmretrofit.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class QuoteApplicationClass : Application()  {

    lateinit var quoteRepostryRetrofit: QuoteRepostryRetrofit

    override fun onCreate() {
        super.onCreate()
        intialise()
        setupworker()
    }

    private fun setupworker() {
        val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workrequest = PeriodicWorkRequest.Builder(QuoteWorker::class.java,10,TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()
        WorkManager.getInstance(this).enqueue(workrequest)
    }

    private fun intialise() {
val quiteserview = RetrofitHelper.getinstance().create(QuoteServices::class.java)
        val databaseclass = QuoteDatabaseClass.getDatabase(applicationContext)

        quoteRepostryRetrofit = QuoteRepostryRetrofit(quiteserview,databaseclass,applicationContext)


    }
}