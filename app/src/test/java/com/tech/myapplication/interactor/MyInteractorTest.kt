package com.tech.myapplication.interactor

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.then
import com.tech.myapplication.controller.MyController
import com.tech.myapplication.presenter.MyPresenter
import com.tech.myapplication.repository.MyRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MyInteractorTest {
    @Mock
    private lateinit var repository : MyRepository
    @Mock
    private lateinit var presenter : MyPresenter
    private lateinit var interactor: MyInteractor


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        interactor = MyInteractor(repository,presenter)
    }

    @Test
    fun getJoke() {
        val joke = ChuckNorris("my joke")
        // GIVEN
        given(repository.getJoke()).willReturn(joke)
        // WHEN
        interactor.getJoke()
        // THEN
        then(presenter).should().present(joke)
    }
}