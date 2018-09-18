package com.example.dicoding.retrofittestingwithrx.match

import com.example.dicoding.retrofittestingwithrx.repository.MatchRepositoryCallback
import com.example.dicoding.retrofittestingwithrx.entity.MatchResponse

interface MatchView : MatchRepositoryCallback<MatchResponse> {
    fun onShowLoading()
    fun onHideLoading()
}