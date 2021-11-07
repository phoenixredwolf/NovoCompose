package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "repair_table",
    foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                parentColumns = ["vehicle_id"],
                                childColumns = ["vehicle_id"],
                                onDelete = CASCADE),
                    ForeignKey( entity = Mechanic::class,
                                parentColumns = ["mech_id"],
                                childColumns = ["brake_mech"],
                                onDelete = CASCADE),
                    ForeignKey( entity = Mechanic::class,
                                parentColumns = ["mech_id"],
                                childColumns = ["accel_mech"],
                                onDelete = CASCADE)]
)
data class RepairList(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "repair_id") val repairID: Int = 0,
    @ColumnInfo(name = "brake_repair") val brakes: Boolean,
    @ColumnInfo(name = "brake_mech") val brakeMech: Int?,
    @ColumnInfo(name = "brake_start") val brakeStart: Calendar?,
    @ColumnInfo(name = "brake_end") val brakeEnd: Calendar?,
    @ColumnInfo(name = "accel_repair") val accel: Boolean,
    @ColumnInfo(name = "accel_mech") val accelMech: Int?,
    @ColumnInfo(name = "accel_start") val accelStart: Calendar?,
    @ColumnInfo(name = "accel_end") val accelEnd: Calendar?,
    @ColumnInfo(name = "complete") val repairComp: Boolean,
    @ColumnInfo(name = "reinspection") val reinspection: Boolean,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Int
)
