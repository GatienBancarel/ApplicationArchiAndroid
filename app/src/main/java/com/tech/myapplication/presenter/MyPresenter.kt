package com.tech.myapplication.presenter

import com.tech.myapplication.interactor.Product

interface MyView {
    fun display(viewModel: List<ProductViewModel>)
}

class MyPresenter(
    private val view: MyView
) {

    fun present(listProduct: List<Product>) {
        val listProductViewModel = listProduct.map { product -> ProductViewModel(product.name) }
        // Revenir au main thread
        view.display(listProductViewModel)
    }
}