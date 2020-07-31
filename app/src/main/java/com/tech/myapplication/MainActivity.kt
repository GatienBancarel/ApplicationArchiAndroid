package com.tech.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import com.tech.myapplication.controller.MyControllerDecorator
import com.tech.myapplication.presenter.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var controller: MyControllerDecorator
    @Inject lateinit var viewModel: MyViewModel

    private val chuckNorrisObserver =
        Observer<ChuckNorrisViewModel> { data ->  textView1.text = data.value }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.liveData.observe(this, chuckNorrisObserver)
    }

    fun getJoke (view: View) {
        controller.onCreate()
    }
}
