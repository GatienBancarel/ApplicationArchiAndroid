package com.tech.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tech.myapplication.controller.MyController
import com.tech.myapplication.interactor.MyInteractor
import com.tech.myapplication.presenter.MyPresenter
import com.tech.myapplication.presenter.MyView
import com.tech.myapplication.presenter.ProductViewModel
import com.tech.myapplication.repository.MyRepository

class MainActivity : AppCompatActivity(), MyView {

    private val controller = MyController(
        MyInteractor(
            MyRepository(),
            MyPresenter(this)
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.onCreate()
    }

    override fun display(viewModel: List<ProductViewModel>) {
       Log.i("PBA", viewModel.toString())
    }

}
