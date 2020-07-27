package com.tech.myapplication.presenter

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tech.myapplication.interactor.ChuckNorris
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MyPresenterTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var context: Context
    private var viewModel: MyViewModel = MyViewModel()
    private lateinit var presenter: MyPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = MyPresenter(viewModel, context)
    }

    @Test
    fun present() {
        // WHEN
        presenter.present(ChuckNorris("Exemple de blague"))

        // THEN
        assert(viewModel.liveData.value == ChuckNorrisViewModel("Exemple de blague"))
    }
}