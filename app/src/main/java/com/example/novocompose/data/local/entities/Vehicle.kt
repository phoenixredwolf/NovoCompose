package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle_table")
data class Vehicle(
    @PrimaryKey(autoGenerate = true) val vehicleID: Long,
    @ColumnInfo(name = "make") val make: String,
    @ColumnInfo(name = "model") val model: String,
    @ColumnInfo(name = "year") val year: Int
)
