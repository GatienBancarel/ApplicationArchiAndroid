package com.tech.myapplication.repository

import com.tech.myapplication.interactor.Product

class MyRepository {
    fun getProducts() : List<Product> {
        // Appel réseau avec OKHttp (library)
        val responseWebService = listOf(
            ProductJSON("Balenciaga", 700, 0, "FR"),
            ProductJSON("Pomme", 2, 1, "US")
        )
        return responseWebService.map { productJSON -> Product(productJSON.name, productJSON.price) }
    }
}