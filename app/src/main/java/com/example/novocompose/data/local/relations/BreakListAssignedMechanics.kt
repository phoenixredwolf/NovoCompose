package com.example.novocompose.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.novocompose.data.local.entities.BrakeInspection
import com.example.novocompose.data.local.entities.Mechanic

data class BreakListAssignedMechanics(
    @Embedded val brakeInsp: BrakeInspection,
    @Relation(
        parentColumn = "mechanic_id",
        entityColumn = "mechanic_id"
    )
    val mechanic: Mechanic
)