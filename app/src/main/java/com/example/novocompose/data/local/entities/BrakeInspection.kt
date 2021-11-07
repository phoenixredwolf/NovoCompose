package com.example.novocompose.data.local.entities

import android.icu.util.Calendar
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.sql.Timestamp

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
    @ColumnInfo(name = "brake_id") val brakeID: Int = 0,
    @ColumnInfo(name = "brake_insp") val brakeInsp: Boolean,
    @ColumnInfo(name = "list_timestamp") val brakeListTime: Calendar,
    @ColumnInfo(name = "insp_timestamp") val brakeInspTime: Calendar?,
    @ColumnInfo(name = "mech_id") val brakeInspector: Int?,
    @ColumnInfo(name = "brake_result") val brakeResult: String?,
    @ColumnInfo(name = "res_timestamp") val brakeResTime: Calendar?,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Int
)
