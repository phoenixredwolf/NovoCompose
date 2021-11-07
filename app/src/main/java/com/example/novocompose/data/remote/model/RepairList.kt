package com.example.novocompose.data.remote.model

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class RepairList(
    val brakeInsp: Boolean,
    val brakeComp: Boolean?,
    val brakeOnList: Date?,
    val brakeMechanic: Mechanic?,
    val brakeStart: Date?,
    val brakeFinish: Date?,
    val brakeReinspect: Boolean?,
    val accelInsp: Boolean,
    val accelComp: Boolean?,
    val accelOnList: Date?,
    val accelMechanic: Mechanic?,
    val accelStart: Date?,
    val accelFinish: Date?,
    val accelReinspect: Boolean?
    )
