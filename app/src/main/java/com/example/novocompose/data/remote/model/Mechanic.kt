package com.example.novocompose.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Mechanic(
    val lastName: String,
    val firstName: String,
    val id: String
)