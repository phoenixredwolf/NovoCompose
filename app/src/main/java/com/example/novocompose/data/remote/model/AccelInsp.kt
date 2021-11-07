package com.example.novocompose.data.remote.model

import com.example.novocompose.data.remote.util.Results
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class AccelInsp(
    val inspect: Boolean,
    val inspectDate: Date?,
    val result: Results?,
    val mechanic: Mechanic?,
    val repair: Boolean?
)
