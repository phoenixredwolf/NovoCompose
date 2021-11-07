package com.example.novocompose.data.remote.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MechanicRepsonseDTO(
    val customers: List<Customers>
)