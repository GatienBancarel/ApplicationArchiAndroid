package com.tech.myapplication.presenter

import android.content.Context
import android.os.Handler
import com.tech.myapplication.interactor.ChuckNorris
import com.tech.myapplication.interactor.Product


interface MyView {
    fun display(viewModel: ChuckNorrisViewModel)
}

class MyPresenter(private val view: MyView, private val context: Context) {

    fun present(joke: ChuckNorris) {
        //val listProductViewModel = listProduct.map { product -> ProductViewModel(product.name) }
        val chuckNorrisViewModel = ChuckNorrisViewModel(joke.value)

        Handler(context.mainLooper).post{
            view.display(chuckNorrisViewModel)}
    }
}