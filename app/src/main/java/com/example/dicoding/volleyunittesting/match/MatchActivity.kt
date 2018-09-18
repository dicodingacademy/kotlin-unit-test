package com.example.dicoding.volleyunittesting.match

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.dicoding.volleyunittesting.R
import com.example.dicoding.volleyunittesting.entity.MatchResponse
import com.example.dicoding.volleyunittesting.repository.MatchRepository

class MatchActivity : AppCompatActivity(), MatchView {
    override fun onShowLoading() {

    }

    override fun onHideLoading() {

    }

    override fun onDataLoaded(data: MatchResponse?) {
        Toast.makeText(this , "Size ${data?.events?.size}" , Toast.LENGTH_SHORT).show()
    }

    override fun onDataError() {
        Toast.makeText(this , "Data Error", Toast.LENGTH_SHORT).show()
    }

    private lateinit var presenter: MatchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match)

        presenter = MatchPresenter(this , MatchRepository(this))
        presenter.getNextMatch("4328")
    }
}
