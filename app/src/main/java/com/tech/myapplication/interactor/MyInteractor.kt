package com.tech.myapplication.interactor

import com.tech.myapplication.presenter.MyPresenter
import com.tech.myapplication.repository.MyRepository
import javax.inject.Inject

class MyInteractor @Inject constructor(
    val repository: MyRepository,
    val presenter: MyPresenter
) {

    fun getJoke() {
        val joke = repository.getJoke()
        //products.filter { it.price < 500 }
        presenter.present(joke)
    }
}