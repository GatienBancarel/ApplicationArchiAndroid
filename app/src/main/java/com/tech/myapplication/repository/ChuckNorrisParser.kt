package com.tech.myapplication.repository

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

class ChuckNorrisParser @Inject constructor() {
    fun parse(body: String?) : ChuckNorrisJSON? {
        val moshi: Moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ChuckNorrisJSON> = moshi.adapter(ChuckNorrisJSON::class.java)
        return adapter.fromJson(body)
    }
}