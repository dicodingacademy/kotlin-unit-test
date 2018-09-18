package com.example.dicoding.retorfittesting.match

import com.example.dicoding.retorfittesting.entity.MatchResponse
import com.example.dicoding.retorfittesting.repository.MatchRepository
import com.example.dicoding.retorfittesting.repository.MatchRepositoryCallback

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