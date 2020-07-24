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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyView {

    private val controller = MyController( MyInteractor(MyRepository(), MyPresenter(this,this)) )

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("gatien","coucou")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.onCreate()
    }

    override fun display(viewModel: List<ProductViewModel>) {
        Log.i("Pbancarel", viewModel.toString())
        textView1.text = viewModel[1].name
    }
}