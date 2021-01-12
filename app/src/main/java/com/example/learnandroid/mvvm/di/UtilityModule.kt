package com.example.learnandroid.mvvm.di

import com.example.learnandroid.mvvm.utils.SharedPreferencesManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val utilityModule = module {
    single { SharedPreferencesManager(androidContext()) }
}