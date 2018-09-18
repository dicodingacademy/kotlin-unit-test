package com.example.dicoding.retrofittestingwithrx.repository

interface MatchRepositoryCallback<T> {

    fun onDataLoaded(data: T?)
    fun onDataError()
}