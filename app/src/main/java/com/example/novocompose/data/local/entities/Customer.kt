package com.example.novocompose.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table",
        foreignKeys = [ForeignKey(  entity = Vehicle::class,
                                    parentColumns = ["vehicle_id"],
                                    childColumns = ["vehicle_id"],
                                    onDelete = CASCADE)])
data class Customer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "customer_id") val customerID: Long,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "street_addr") val streetAddr: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "state") val state: String,
    @ColumnInfo(name = "zip_code") val zipCode: String,
    @ColumnInfo(name = "phone") val phoneNumber: String,
    @ColumnInfo(name = "vehicle_id") val vehicleID: Long
)
