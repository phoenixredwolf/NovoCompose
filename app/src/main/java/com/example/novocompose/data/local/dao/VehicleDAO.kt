package com.example.novocompose.data.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.novocompose.data.local.entities.Vehicle
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDAO {

    // Get all
    @Query("Select * From vehicle_table")
    fun getAllVehicles(): Flow<List<Vehicle>>

    // Get specific vehicle
    @Query("Select * From vehicle_table Where vehicle_id = :vehicleID")
    suspend fun getVehicle(vehicleID: Long): Vehicle

    // Delete specific vehicle
    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    // Delete all vehicles
    @Query("Delete from vehicle_table")
    suspend fun deleteAllVehicles()

    // Insert new vehicle
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVehicle(vehicle: Vehicle): Long

    // Update vehicle
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateVehicle(vehicle: Vehicle)
}