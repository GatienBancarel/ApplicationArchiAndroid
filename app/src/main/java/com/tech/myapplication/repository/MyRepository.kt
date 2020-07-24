package com.tech.myapplication.repository

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tech.myapplication.interactor.Product
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException



class MyRepository {
    // Appel réseau avec OKHttp (library)
    val client = OkHttpClient()

    fun getProducts() : List<Product> {
        val request = Request.Builder()
            .url("https://api.chucknorris.io/jokes/random")
            .build()
        val response = client.newCall(request).execute()

        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ChuckNorrisJSON> = moshi.adapter(ChuckNorrisJSON::class.java)
        val joke = adapter.fromJson(response.body?.string())

        Log.i("Gbancarel", joke.toString() )

        val responseWebService = listOf(
            ProductJSON("Balenciaga", 700, 0, "FR"),
            ProductJSON("Pomme", 2, 1, "US")
        )
        return responseWebService.map { productJSON -> Product(productJSON.name, productJSON.price) }

    }
}