package com.example.novocompose.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.novocompose.data.local.entities.AccelerationInsp
import com.example.novocompose.data.local.entities.Mechanic

data class AccelAssingedMechanics(
    @Embedded val accelInsp: AccelerationInsp,
    @Relation(
        parentColumn = "mechanic_id",
        entityColumn = "mechanic_id"
    )
    val mechanic: Mechanic
)