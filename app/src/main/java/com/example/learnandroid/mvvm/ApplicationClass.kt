package com.example.learnandroid.mvvm

import android.app.Application
import com.example.learnandroid.BuildConfig.*
import com.example.learnandroid.mvvm.di.networkModule
import com.example.learnandroid.mvvm.di.repositoryModule
import com.example.learnandroid.mvvm.di.utilityModule
import com.example.learnandroid.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationClass : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            if (DEBUG) {
                androidLogger()
            } else {
            androidLogger(Level.NONE)
        }
            androidContext(this@ApplicationClass)
            modules(
                utilityModule,
                viewModelModule,
                networkModule,
                repositoryModule
            )
        }
    }
}