package com.example.dicoding.volleyunittesting.repository

interface MatchRepositoryCallback<T> {

    fun onDataLoaded(data: T?)
    fun onDataError()
}