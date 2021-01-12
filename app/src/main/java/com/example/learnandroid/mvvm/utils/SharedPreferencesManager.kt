package com.example.learnandroid.mvvm.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager (private val context: Context){
    companion object{
        const val TAG = "MOBILE_TEMPLATE_APP"
        const val X_ACCESS_TOKEN = "X-ACCESS-TOKEN"
    }

    private fun getSharedPreferences() : SharedPreferences {
        return context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }

    fun getJwtToken() : String? {
        return getSharedPreferences().getString(X_ACCESS_TOKEN, null)
    }

    fun saveJwtToken(jwtToken : String){
        val spf = getSharedPreferences()
        val editor = spf.edit()
        editor.putString(X_ACCESS_TOKEN, jwtToken)
        editor.apply()
    }
}