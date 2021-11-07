package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mechanic_table")
data class Mechanic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mech_id") val mechID: Long,
    @ColumnInfo(name = "last_name") val mechanicLastName: String,
    @ColumnInfo(name = "first_name") val mechanicFirstName: String
)
