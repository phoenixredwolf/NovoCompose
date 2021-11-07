package com.example.novocompose.data.local.entities

import android.icu.util.Calendar
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "accel_insp",
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
    @ColumnInfo(name = "accel_id") val accelID: Int = 0,
    @ColumnInfo(name = "accel_list") val accelInsp: Boolean,
    @ColumnInfo(name = "entry_timestamp") val accelListTime: Calendar,
    @ColumnInfo(name = "insp_timestamp") val accelInspTime: Calendar?,
    @ColumnInfo(name = "mech_id") val accelInspector: Int?,
    @ColumnInfo(name = "accel_res") val accelResult: String?,
    @ColumnInfo(name = "result_timestamp") val accelResTime: Calendar?,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Int

)
