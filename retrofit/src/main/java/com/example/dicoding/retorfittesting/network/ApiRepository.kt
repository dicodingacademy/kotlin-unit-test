package com.example.dicoding.retorfittesting.network

import com.example.dicoding.retorfittesting.entity.MatchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {
    @GET("api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String): Call<MatchResponse>
}