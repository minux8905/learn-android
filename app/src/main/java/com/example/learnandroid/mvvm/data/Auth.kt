package com.example.learnandroid.mvvm.data

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName(value = "jwt") val token: String
)
