package com.tech.myapplication.repository

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tech.myapplication.interactor.ChuckNorris
import com.tech.myapplication.interactor.Product
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException
import java.lang.Exception


class MyRepository {
    // Appel réseau avec OKHttp (library)
    val client = OkHttpClient()

    fun getJoke() : ChuckNorris {
        val request = Request.Builder()
            .url("https://api.chucknorris.io/jokes/random")
            .build()
        val response = client.newCall(request).execute()

        //todo check statut code
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ChuckNorrisJSON> = moshi.adapter(ChuckNorrisJSON::class.java)
        val chuckNorrisEntityJSON = adapter.fromJson(response.body?.string())
        if (chuckNorrisEntityJSON != null) {
            return ChuckNorris(chuckNorrisEntityJSON.value)
        } else {
            throw CannotDecodeJsonException("adapter from json à échoué")
        }

        //return chuckNorrisEntityJSON.map { ChuckNorris(it.value) }

    }
}