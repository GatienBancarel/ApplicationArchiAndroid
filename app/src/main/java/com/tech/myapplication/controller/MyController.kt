package com.tech.myapplication.controller

import com.tech.myapplication.interactor.MyInteractor

class MyController(val interactor: MyInteractor) {

    fun onCreate() {
        // Passer au background thread
        Thread {
            interactor.getProducts()
        }.start()
    }
}