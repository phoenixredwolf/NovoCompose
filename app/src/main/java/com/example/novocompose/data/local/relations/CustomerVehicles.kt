package com.example.novocompose.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.novocompose.data.local.entities.Customer
import com.example.novocompose.data.local.entities.Vehicle

data class CustomerVehicles(
    @Embedded val customer: Customer,
    @Relation(
        parentColumn = "vehicle_id",
        entityColumn = "vehicle_id"
    )
    val vehicles: List<Vehicle>
)
