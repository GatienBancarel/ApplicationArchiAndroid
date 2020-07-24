package com.tech.myapplication.presenter

import android.content.Context
import android.os.Handler
import com.tech.myapplication.interactor.Product


interface MyView {
    fun display(viewModel: List<ProductViewModel>)
}

class MyPresenter(private val view: MyView, private val context: Context) {

    fun present(listProduct: List<Product>) {
        val listProductViewModel = listProduct.map { product -> ProductViewModel(product.name) }

        Handler(context.mainLooper).post{
            view.display(listProductViewModel)}
    }
}