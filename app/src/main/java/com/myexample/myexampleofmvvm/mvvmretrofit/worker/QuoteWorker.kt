package com.myexample.myexampleofmvvm.mvvmretrofit.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.myexample.myexampleofmvvm.QuoteApplicationClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(
    private val context: Context,
    val param:WorkerParameters,

): Worker(context,param) {
    override fun doWork(): Result {
        val respositry = (context as QuoteApplicationClass).quoteRepostryRetrofit

        CoroutineScope(Dispatchers.IO).launch{
            respositry.getquotinbackground()
        }
        return Result.success()
    }

}