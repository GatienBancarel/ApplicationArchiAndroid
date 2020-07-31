package com.tech.myapplication.interactor

import com.tech.myapplication.presenter.MyPresenter
import com.tech.myapplication.repository.CannotDecodeJsonException
import com.tech.myapplication.repository.ErrorStatusException
import com.tech.myapplication.repository.MyRepository
import javax.inject.Inject

class MyInteractor @Inject constructor(
    val repository: MyRepository,
    val presenter: MyPresenter
) {

    fun getJoke() {
        try {
            val joke = repository.getJoke()
            presenter.present(joke)
        } catch (e1: CannotDecodeJsonException) {
            presenter.presentError()
        } catch (e1: ErrorStatusException) {
            presenter.presentError()
        }

    }
}