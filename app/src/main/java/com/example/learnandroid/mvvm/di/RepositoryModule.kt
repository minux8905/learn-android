package com.example.learnandroid.mvvm.di

import com.example.learnandroid.mvvm.data.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(get()) }
}