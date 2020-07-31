package com.tech.myapplication.repository

import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

data class Response(
    val statusCode: Int,
    val body: String?
)

class ChuckNorrisService @Inject constructor(
    val client: OkHttpClient // Appel réseau avec OKHttp (library)
) {

    fun get(url: String) : Response {
        val request = Request.Builder()
            .url(url)
            .build()
        val response = client.newCall(request).execute()
        return Response(
            response.code,
            response.body?.string()
        )
    }
}