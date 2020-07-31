package com.tech.myapplication.controller

import com.tech.myapplication.interactor.MyInteractor
import javax.inject.Inject

interface MyControllerInterface {
    fun onCreate()
}

class MyController @Inject constructor(
    val interactor: MyInteractor
) {

    fun onCreate() {
        interactor.getJoke()
    }
}

class MyControllerDecorator(val controller: MyController) : MyControllerInterface {
    override fun onCreate() {
        Thread {
            controller.onCreate()
        }.start()
    }

}