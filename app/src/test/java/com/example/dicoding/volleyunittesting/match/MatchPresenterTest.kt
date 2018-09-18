package com.example.dicoding.volleyunittesting.match

import com.example.dicoding.volleyunittesting.entity.MatchResponse
import com.example.dicoding.volleyunittesting.repository.MatchRepository
import com.example.dicoding.volleyunittesting.repository.MatchRepositoryCallback
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MatchPresenterTest{

    @Mock
    private lateinit var view: MatchView

    @Mock
    private lateinit var matchRepository: MatchRepository

    @Mock
    private lateinit var matchResponse: MatchResponse

    private lateinit var matchPresenter: MatchPresenter

    @Before
    fun set(){
        MockitoAnnotations.initMocks(this)

        matchPresenter = MatchPresenter(view , matchRepository)
    }

    @Test
    fun getMatchLoadedTest() {

        val id = "4328"

        matchPresenter.getNextMatch(id)
        argumentCaptor<MatchRepositoryCallback<MatchResponse?>>().apply {

            verify(matchRepository).getNextMatch(eq(id), capture())
            firstValue.onDataLoaded(matchResponse)
        }

        Mockito.verify(view).onShowLoading()
        Mockito.verify(view).onDataLoaded(matchResponse)
        Mockito.verify(view).onHideLoading()
    }

    @Test
    fun getMatchErrorTest() {

        matchPresenter.getNextMatch("")

        argumentCaptor<MatchRepositoryCallback<MatchResponse?>>().apply {

            verify(matchRepository).getNextMatch(eq(""), capture())
            firstValue.onDataError()
        }

        Mockito.verify(view).onShowLoading()
        Mockito.verify(view).onDataError()
        Mockito.verify(view).onHideLoading()
    }

}