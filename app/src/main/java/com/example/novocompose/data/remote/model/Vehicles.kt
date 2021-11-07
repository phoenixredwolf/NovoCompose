package com.example.novocompose.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Vehicles(
    val make: String,
    val model: String,
    val year: String,
    val accelInsp: List<AccelInsp>?,
    val brakeInsp: List<BrakeInsp>?,
    val repairs: List<RepairList>?
)