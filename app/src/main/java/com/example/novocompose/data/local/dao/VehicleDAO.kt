package com.example.novocompose.data.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.novocompose.data.local.entities.Vehicle

@Dao
interface VehicleDAO {

    // Get all
    @Query("Select * From vehicle_table")
    suspend fun getAllVehicles(): List<Vehicle>

    // Get specific vehicle
    @Query("Select * From vehicle_table Where vehicleID = :vehicleID")
    suspend fun getVehicle(vehicleID: Int): Vehicle

    // Delete specific vehicle
    @Delete
    suspend fun deleteVehicle(vararg vehicle: Vehicle)

    // Delete all vehicles
    @Query("Delete from vehicle_table")
    suspend fun deleteAllVehicles(): Unit

    // Insert new vehicle
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVehicle(vehicle: Vehicle): Int

    // Update vehicle
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateVehicle(vehicle: Vehicle)
}