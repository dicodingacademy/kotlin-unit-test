package com.example.dicoding.retorfittesting.match

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding.retorfittesting.R
import com.example.dicoding.retorfittesting.entity.MatchResponse
import com.example.dicoding.retorfittesting.repository.MatchRepository

class MatchActivity : AppCompatActivity(), MatchView {

    override fun onShowLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onHideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataLoaded(data: MatchResponse?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var matchPresenter: MatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        matchPresenter = MatchPresenter(this , MatchRepository())
    }
}
