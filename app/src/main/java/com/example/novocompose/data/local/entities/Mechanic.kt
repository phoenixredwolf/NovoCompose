package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mechanic_table")
data class Mechanic(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mechanic_id") val mechID: Int = 0,
    @ColumnInfo(name = "last_name") val mechanicLastName: String,
    @ColumnInfo(name = "first_name") val mechanicFirstName: String
)
