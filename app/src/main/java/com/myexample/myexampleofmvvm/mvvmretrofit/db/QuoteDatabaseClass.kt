package com.myexample.myexampleofmvvm.mvvmretrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myexample.myexampleofmvvm.mvvmretrofit.models.Result


@Database(entities = [Result::class], version = 1)
abstract class QuoteDatabaseClass :RoomDatabase() {

    abstract fun quoteDao(): QuoteRetrofitDao

    companion object {

        @Volatile
        private var INSTANCE: QuoteDatabaseClass? = null

        fun getDatabase(context: Context): QuoteDatabaseClass {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteDatabaseClass::class.java,
                        "quote_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }

    }
}