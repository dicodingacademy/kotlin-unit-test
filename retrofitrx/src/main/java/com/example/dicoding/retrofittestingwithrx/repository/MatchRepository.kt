package com.example.dicoding.retrofittestingwithrx.repository

import com.example.dicoding.retrofittestingwithrx.entity.MatchResponse
import com.example.dicoding.retrofittestingwithrx.network.ApiRepository
import com.example.dicoding.retrofittestingwithrx.network.MyRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MatchRepository {

    fun getNextMatch(id: String, callback: MatchRepositoryCallback<MatchResponse?>) {
        MyRetrofit
                .createService(ApiRepository::class.java)
                .getNextMatch(id)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    data?.let {
                        callback.onDataLoaded(it)
                    } ?: run {
                        callback.onDataError()
                    }
                }, {
                    callback.onDataError()
                })
    }
}