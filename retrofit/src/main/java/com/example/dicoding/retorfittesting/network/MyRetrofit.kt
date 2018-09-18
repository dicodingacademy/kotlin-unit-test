package com.example.dicoding.retorfittesting.network

import com.example.dicoding.retorfittesting.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyRetrofit {

    private fun iniRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun <T> createService(service: Class<T>): T {
        return iniRetrofit().create(service)
    }

}