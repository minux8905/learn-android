package com.example.learnandroid.mvvm.data

import com.google.gson.annotations.SerializedName
import io.reactivex.internal.operators.single.SingleDoOnSuccess

data class AuthResponse(
    @SerializedName(value = "isSuccess") val isSuccess : Boolean,
    @SerializedName(value = "code") val code : Int,
    @SerializedName(value = "message") val message : String,
    @SerializedName(value = "result") val auth : Auth
)
