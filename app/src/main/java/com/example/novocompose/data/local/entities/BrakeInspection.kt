package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "brakes_table",
        foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                    parentColumns = ["vehicleID"],
                                    childColumns = ["vehicle_id"],
                                    onDelete = CASCADE)])
data class BrakeInspection(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "brake_insp") val brakeInsp: Boolean,
    @ColumnInfo(name = "brake_result") val brakeResult: String,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Long
)
