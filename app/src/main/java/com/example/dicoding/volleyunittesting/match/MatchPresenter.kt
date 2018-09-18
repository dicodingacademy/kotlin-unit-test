package com.example.dicoding.volleyunittesting.match

import com.example.dicoding.volleyunittesting.entity.MatchResponse
import com.example.dicoding.volleyunittesting.repository.MatchRepository
import com.example.dicoding.volleyunittesting.repository.MatchRepositoryCallback

class MatchPresenter(private val view: MatchView, private val matchRepository: MatchRepository) {

    fun getNextMatch(id: String) {
        view.onShowLoading()
        matchRepository.getNextMatch(id , object : MatchRepositoryCallback<MatchResponse?> {
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