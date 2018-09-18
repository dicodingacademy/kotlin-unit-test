package com.example.dicoding.retrofittestingwithrx.match

import com.example.dicoding.retrofittestingwithrx.repository.MatchRepositoryCallback
import com.example.dicoding.retrofittestingwithrx.entity.MatchResponse
import com.example.dicoding.retrofittestingwithrx.repository.MatchRepository

class MatchPresenter(private val view: MatchView, private val matchRepository: MatchRepository) {

    fun getMatch(id: String) {
        view.onShowLoading()
        matchRepository.getNextMatch(id, object : MatchRepositoryCallback<MatchResponse?> {
            override fun onDataLoaded(data: MatchResponse?) {
                view.onDataLoaded(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
        view.onHideLoading()
    }
}