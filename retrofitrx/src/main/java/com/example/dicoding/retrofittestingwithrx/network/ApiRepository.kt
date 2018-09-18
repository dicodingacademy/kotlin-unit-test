package com.example.dicoding.retrofittestingwithrx.network

import com.example.dicoding.retrofittestingwithrx.entity.MatchResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {
    @GET("api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String): Observable<MatchResponse?>
}