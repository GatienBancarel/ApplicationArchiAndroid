package com.tech.myapplication.presenter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.myapplication.interactor.ChuckNorris
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MyPresenterTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private var viewModel: MyViewModel = MyViewModel()
    private lateinit var presenter: MyPresenter

    @Before
    fun setUp() {
        presenter = MyPresenter(viewModel)
    }

    @Test
    fun present() {
        // WHEN
        presenter.present(ChuckNorris("Exemple de blague"))

        // THEN
        assert(viewModel.liveData.value == ChuckNorrisViewModel("Exemple de blague"))
    }
}