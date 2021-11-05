package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "repair_table",
    foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                parentColumns = ["vehicleID"],
                                childColumns = ["vehicle_id"],
                                onDelete = CASCADE)]
)
data class RepairList(
    @PrimaryKey(autoGenerate = true) val repair_id: Long,
    @ColumnInfo(name = "brake_repair") val brakes: Boolean,
    @ColumnInfo(name = "accel_repair") val accel: Boolean,
    @ColumnInfo(name = "complete") val repairComp: Boolean,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Long
)
