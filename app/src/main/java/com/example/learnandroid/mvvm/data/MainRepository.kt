package com.example.learnandroid.mvvm.data

import com.example.learnandroid.mvvm.api.MainService

class MainRepository(private val mainService: MainService){
    suspend fun login(user : User) = mainService.login(user)
}
