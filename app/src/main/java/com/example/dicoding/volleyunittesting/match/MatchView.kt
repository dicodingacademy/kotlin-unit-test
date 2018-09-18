package com.example.dicoding.volleyunittesting.match

import com.example.dicoding.volleyunittesting.entity.MatchResponse
import com.example.dicoding.volleyunittesting.repository.MatchRepositoryCallback

interface MatchView : MatchRepositoryCallback<MatchResponse> {
    fun onShowLoading()
    fun onHideLoading()
}