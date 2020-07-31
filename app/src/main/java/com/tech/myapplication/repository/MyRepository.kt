package com.tech.myapplication.repository

import com.tech.myapplication.interactor.ChuckNorris
import javax.inject.Inject
import kotlin.Exception

class MyRepository @Inject constructor(
    var service: ChuckNorrisService,
    var parser: ChuckNorrisParser
) {

    @Throws(
        ErrorStatusException::class,
        CannotDecodeJsonException::class
    )
    fun getJoke() : ChuckNorris {
        val response = service.get("https://api.chucknorris.io/jokes/random")

        if (response.statusCode != 200 && response.statusCode != 201) {
            throw ErrorStatusException()
        }

        val chuckNorrisEntityJSON = parser.parse(response.body)

        if (chuckNorrisEntityJSON != null) {
            return ChuckNorris(chuckNorrisEntityJSON.value)
        } else {
            throw CannotDecodeJsonException("adapter from json à échoué")
        }
    }
}

class ErrorStatusException : Exception()