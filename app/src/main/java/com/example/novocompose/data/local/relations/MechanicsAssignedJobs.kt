package com.example.novocompose.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.novocompose.data.local.entities.AccelerationInsp
import com.example.novocompose.data.local.entities.BrakeInspection
import com.example.novocompose.data.local.entities.Mechanic
import com.example.novocompose.data.local.entities.RepairList

data class MechanicsAssignedJobs(
    @Embedded val mechanic: Mechanic,
    @Relation(
        parentColumn = "mech_id",
        entityColumn = "mech_id"
    )
    val brakeInsp: List<BrakeInspection>,
    @Relation(
        parentColumn = "mech_id",
        entityColumn = "mech_id"
    )
    val accelInsp: List<AccelerationInsp>,
    @Relation(
        parentColumn = "mech_id",
        entityColumn = "brake_mech"
    )
    val brakeRepairs: List<RepairList>,
    @Relation(
        parentColumn = "mech_id",
        entityColumn = "brake_mech"
    )
    val accelRepairs: List<RepairList>
)