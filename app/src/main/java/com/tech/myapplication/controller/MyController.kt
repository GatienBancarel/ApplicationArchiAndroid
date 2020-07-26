package com.tech.myapplication.controller

import com.tech.myapplication.interactor.MyInteractor
interface MyControllerInterface {
    fun onCreate()
}
class MyController(val interactor: MyInteractor) {

    fun onCreate() {
        interactor.getJoke()
    }
}

class MyControllerDecorator(val controller: MyController): MyControllerInterface{
    override fun onCreate() {
        Thread {
            controller.onCreate()
        }.start()
    }

}