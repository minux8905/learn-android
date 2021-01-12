package com.example.learnandroid.mvvm.ui

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learnandroid.mvvm.data.MainRepository
import com.example.learnandroid.mvvm.data.User
import com.example.learnandroid.mvvm.utils.SharedPreferencesManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val application : Application,  private val repository : MainRepository, private val sharedPreferencesManager: SharedPreferencesManager): ViewModel(){
    val id: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    val pw: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            postValue("")
        }
    }

    private fun getUser() : User = User(id.value ?: "", pw.value ?: "")

    private fun clearUser() {
        id.postValue("")
        pw.postValue("")
    }

    fun login(){
        Toast.makeText(application,"Click!", Toast.LENGTH_SHORT).show()

        viewModelScope.launch (Dispatchers.IO){
            try{
                val response = repository.login(getUser())
                sharedPreferencesManager.saveJwtToken(response.auth.token)
                Toast.makeText(application,"JWT! ${response.message}", Toast.LENGTH_SHORT).show()
            }catch (e : Exception){
                clearUser()

            }
        }
    }

}