package com.example.learnandroid.mvvm.data

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "id") val id: String,
    @SerializedName(value = "pw") val pw: String
)
