package com.example.novocompose.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Customers(
    val lastName: String,
    val firstName: String,
    val streetAddr: String,
    val city: String,
    val state: String,
    val zip: String,
    val vehicles: List<Vehicles>
)
