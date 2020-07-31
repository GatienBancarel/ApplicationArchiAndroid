package com.tech.myapplication.repository

import com.nhaarman.mockitokotlin2.given
import com.tech.myapplication.interactor.ChuckNorris
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MyRepositoryTest {
    @Mock
    lateinit var service: ChuckNorrisService
    @Mock
    lateinit var parser: ChuckNorrisParser
    lateinit var repository: MyRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = MyRepository(service, parser)
    }

    @Test
    fun getJoke_whenGetJokeSuccess() {
        // GIVEN
        given(service.get("https://api.chucknorris.io/jokes/random"))
            .willReturn(Response(200, "{\"categories\":[],\"created_at\":\"2020-01-05 13:42:19.104863\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"x1Orz56-S4OoIcgcYyjNsA\",\"updated_at\":\"2020-01-05 13:42:19.104863\",\"url\":\"https://api.chucknorris.io/jokes/x1Orz56-S4OoIcgcYyjNsA\",\"value\":\"Chuck Norris organised a weekend trip .... for 5 days\"}"))
        given(parser.parse("{\"categories\":[],\"created_at\":\"2020-01-05 13:42:19.104863\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"x1Orz56-S4OoIcgcYyjNsA\",\"updated_at\":\"2020-01-05 13:42:19.104863\",\"url\":\"https://api.chucknorris.io/jokes/x1Orz56-S4OoIcgcYyjNsA\",\"value\":\"Chuck Norris organised a weekend trip .... for 5 days\"}")).willReturn(
            ChuckNorrisJSON("icon_url", "id", "updated_at", "url", "value")
        )

        // WHEN
        val joke = repository.getJoke()

        // THEN
        assertEquals(joke, ChuckNorris("value"))
    }

    @Test(expected=ErrorStatusException::class)
    fun getJoke_whenGetJokeWrongStatus() {
        // GIVEN
        given(service.get("https://api.chucknorris.io/jokes/random"))
            .willReturn(Response(404, "{\"categories\":[],\"created_at\":\"2020-01-05 13:42:19.104863\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"x1Orz56-S4OoIcgcYyjNsA\",\"updated_at\":\"2020-01-05 13:42:19.104863\",\"url\":\"https://api.chucknorris.io/jokes/x1Orz56-S4OoIcgcYyjNsA\",\"value\":\"Chuck Norris organised a weekend trip .... for 5 days\"}"))

        // WHEN
        repository.getJoke()
    }

    @Test(expected=CannotDecodeJsonException::class)
    fun getJoke_whenGetJokeCannotDecodeJson() {
        // GIVEN
        given(service.get("https://api.chucknorris.io/jokes/random"))
            .willReturn(Response(200, "{\"categories\":[],\"created_at\":\"2020-01-05 13:42:19.104863\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"x1Orz56-S4OoIcgcYyjNsA\",\"updated_at\":\"2020-01-05 13:42:19.104863\",\"url\":\"https://api.chucknorris.io/jokes/x1Orz56-S4OoIcgcYyjNsA\",\"value\":\"Chuck Norris organised a weekend trip .... for 5 days\"}"))
        given(parser.parse("{\"categories\":[],\"created_at\":\"2020-01-05 13:42:19.104863\",\"icon_url\":\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\",\"id\":\"x1Orz56-S4OoIcgcYyjNsA\",\"updated_at\":\"2020-01-05 13:42:19.104863\",\"url\":\"https://api.chucknorris.io/jokes/x1Orz56-S4OoIcgcYyjNsA\",\"value\":\"Chuck Norris organised a weekend trip .... for 5 days\"}")).willReturn(
            null
        )

        // WHEN
        val joke = repository.getJoke()
    }
}