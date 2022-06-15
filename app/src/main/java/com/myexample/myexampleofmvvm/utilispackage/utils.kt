package com.myexample.myexampleofmvvm.utilispackage

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class MyCommonFunctions {

    companion object{
        fun isInterntAvailgle(context:Context):Boolean{

            (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run{
                return this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                    NetworkCapabilities.NET_CAPABILITY_INTERNET
                )?:false
            }
        }
    }

}