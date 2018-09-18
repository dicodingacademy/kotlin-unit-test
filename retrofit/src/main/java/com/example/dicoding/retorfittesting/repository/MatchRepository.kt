package com.example.dicoding.retorfittesting.repository

import com.example.dicoding.retorfittesting.entity.MatchResponse
import com.example.dicoding.retorfittesting.network.ApiRepository
import com.example.dicoding.retorfittesting.network.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchRepository {

    fun getNextMatch(id: String, callback: MatchRepositoryCallback<MatchResponse?>) {
        MyRetrofit
                .createService(ApiRepository::class.java)
                .getNextMatch(id)
                .enqueue(object : Callback<MatchResponse?> {
                    override fun onFailure(call: Call<MatchResponse?>?, t: Throwable?) {
                        callback.onDataError()
                    }

                    override fun onResponse(call: Call<MatchResponse?>?, response: Response<MatchResponse?>?) {
                        response?.let {
                            if (it.isSuccessful) {
                                callback.onDataLoaded(it.body())
                            } else {
                                callback.onDataError()
                            }
                        }
                    }
                })
    }
}