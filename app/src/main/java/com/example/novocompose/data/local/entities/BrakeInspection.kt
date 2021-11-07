package com.example.novocompose.data.local.entities

import android.icu.util.Calendar
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "brakes_table",
        foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                    parentColumns = ["vehicle_id"],
                                    childColumns = ["vehicle_id"],
                                    onDelete = CASCADE),
                        ForeignKey( entity = Mechanic::class,
                                    parentColumns = ["mech_id"],
                                    childColumns = ["mech_id"],
                                    onDelete = CASCADE)])
data class BrakeInspection(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "brake_id") val brakeID: Long,
    @ColumnInfo(name = "brake_insp") val brakeInsp: Boolean,
    @ColumnInfo(name = "list_timestamp") val brakeListTime: Date,
    @ColumnInfo(name = "insp_timestamp") val brakeInspTime: Date?,
    @ColumnInfo(name = "mech_id") val brakeInspector: Long?,
    @ColumnInfo(name = "brake_result") val brakeResult: String?,
    @ColumnInfo(name = "res_timestamp") val brakeResTime: Date?,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Long
)
