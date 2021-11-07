package com.example.novocompose.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.novocompose.data.local.entities.Mechanic
import com.example.novocompose.data.local.entities.RepairList

data class RepairAssignedMechanics(
    @Embedded val repairs: RepairList,
    @Relation(
        parentColumn = "brake_mech",
        entityColumn = "mechanic_id"
    )
    val brakeMech: List<Mechanic>,
    @Relation(
        parentColumn = "accel_mech",
        entityColumn = "mechanic_id"
    )
    val accelMech: List<Mechanic>
)
