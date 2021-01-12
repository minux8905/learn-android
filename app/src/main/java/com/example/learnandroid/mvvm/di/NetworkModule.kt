package com.example.learnandroid.mvvm.di

import com.example.learnandroid.mvvm.api.MainService
import com.example.learnandroid.mvvm.utils.SharedPreferencesManager
import com.example.learnandroid.mvvm.utils.SharedPreferencesManager.Companion.X_ACCESS_TOKEN
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "http://3.35.208.170:9001/"

val networkModule : Module = module {
    fun provideHeaderInterceptor(sharedPreferenceManager : SharedPreferencesManager) = Interceptor{ chain ->
        val request =  chain.request().newBuilder()
            .addHeader(X_ACCESS_TOKEN, "${sharedPreferenceManager.getJwtToken()}")
            .build()

        chain.proceed(request)
    }

    fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().apply { HttpLoggingInterceptor.Level.BODY }


    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, headerInterceptor: Interceptor) = OkHttpClient.Builder()
        .readTimeout(5000, TimeUnit.MILLISECONDS)
        .connectTimeout(5000, TimeUnit.MILLISECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun provideMainService(retrofit: Retrofit): MainService =
        retrofit.create(MainService::class.java)

    single { provideHeaderInterceptor(get()) }
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get(), get()) }
    single { provideRetrofit(get()) }
    single { provideMainService(get()) }
}