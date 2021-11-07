package com.example.novocompose.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.novocompose.data.local.entities.*

data class VehicleListData(
    @Embedded val vehicle: Vehicle,
    @Relation(
        parentColumn = "vehicle_id",
        entityColumn = "vehicle_id"
    )
    val customer: Customer,
    @Relation(
        parentColumn = "vehicle_id",
        entityColumn = "vehicle_id"
    )
    val accelInsp: List<AccelerationInsp>,
    @Relation(
        parentColumn = "vehicle_id",
        entityColumn = "vehicle_id"
    )
    val brakeInsp: List<BrakeInspection>,
    @Relation(
        parentColumn = "vehicle_id",
        entityColumn = "vehicle_id"
    )
    val repairList: List<RepairList>
)
