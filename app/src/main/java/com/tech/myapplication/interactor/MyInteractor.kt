package com.tech.myapplication.interactor

import com.tech.myapplication.presenter.MyPresenter
import com.tech.myapplication.repository.MyRepository

class MyInteractor(
    val repository : MyRepository,
    val presenter : MyPresenter
) {

    fun getProducts() {
        val products = repository.getProducts()
        products.filter { it.price < 500 }
        presenter.present(products)
    }
}