package com.example.learnandroid.mvvm.api

import com.example.learnandroid.mvvm.data.AuthResponse
import com.example.learnandroid.mvvm.data.User
import retrofit2.http.Body
import retrofit2.http.POST

interface MainService {
    @POST("users/login")
    suspend fun login(@Body user : User) : AuthResponse
}
