package com.tech.myapplication.repository

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChuckNorrisJSON (
    val icon_url: String,
    val id: String,
    val updated_at: String,
    val url: String,
    val value: String)