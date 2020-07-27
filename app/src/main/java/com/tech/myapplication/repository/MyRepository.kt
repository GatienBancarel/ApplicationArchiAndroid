package com.tech.myapplication.repository

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.tech.myapplication.interactor.ChuckNorris
import okhttp3.OkHttpClient;
import okhttp3.Request;
import javax.inject.Inject

class MyRepository @Inject constructor(
    val client: OkHttpClient // Appel réseau avec OKHttp (library)
) {

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
    }
}