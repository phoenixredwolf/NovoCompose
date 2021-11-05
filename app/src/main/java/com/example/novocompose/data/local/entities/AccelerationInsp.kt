package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "accel_insp",
        foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                    parentColumns = ["vehicleID"],
                                    childColumns = ["vehicle_id"],
                                    onDelete = CASCADE)])
data class AccelerationInsp(
    @PrimaryKey(autoGenerate = true) val accel_id: Long,
    @ColumnInfo(name = "accel_list") val accelInsp: Boolean,
    @ColumnInfo(name = "accel_res") val accelResult: Boolean,
    @ColumnInfo(name = "vehicle_id") val vehicle_id: Long
)
