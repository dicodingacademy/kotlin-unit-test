package com.example.dicoding.retorfittesting.match

import com.example.dicoding.retorfittesting.entity.MatchResponse
import com.example.dicoding.retorfittesting.repository.MatchRepositoryCallback

interface MatchView : MatchRepositoryCallback<MatchResponse> {
    fun onShowLoading()
    fun onHideLoading()
}