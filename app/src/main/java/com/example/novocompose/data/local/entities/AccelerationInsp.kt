package com.example.novocompose.data.local.entities

import android.icu.util.Calendar
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "accel_table",
        foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                    parentColumns = ["vehicle_id"],
                                    childColumns = ["vehicle_id"],
                                    onDelete = CASCADE),
                        ForeignKey( entity = Mechanic::class,
                                    parentColumns = ["mech_id"],
                                    childColumns = ["mech_id"],
                                    onDelete = CASCADE)])
data class AccelerationInsp(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "accel_id") val accelID: Long,
    @ColumnInfo(name = "accel_list") val accelInsp: Boolean,
    @ColumnInfo(name = "entry_timestamp") val accelListTime: Date,
    @ColumnInfo(name = "insp_timestamp") val accelInspTime: Date?,
    @ColumnInfo(name = "mech_id") val accelInspector: Long?,
    @ColumnInfo(name = "accel_res") val accelResult: String?,
    @ColumnInfo(name = "result_timestamp") val accelResTime: Date?,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Long
)
