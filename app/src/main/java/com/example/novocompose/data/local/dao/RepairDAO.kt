package com.example.novocompose.data.local.dao

import androidx.room.*
import com.example.novocompose.data.local.entities.RepairList
import kotlinx.coroutines.flow.Flow

@Dao
interface RepairDAO {

    // Get all Repairs
    @Query("Select * from repair_table Group By vehicle_id")
    fun getAllRepairs(): Flow<List<RepairList>>

    // Get specific Repairs
    @Query("Select * from repair_table JOIN vehicle_table on (repair_table.vehicle_id = vehicle_table.vehicle_id) Where vehicle_table.vehicle_id = :vehicleID")
    suspend fun getVehicleRepairs(vehicleID: Long): RepairList

    // Insert new repair
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRepair(repair: RepairList): Long

    // Update repair status
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateRepair(repair: RepairList)

    // Delete repair
    @Delete
    suspend fun deleteRepair(repair: RepairList)

    // Delete all repairs
    @Query("DELETE FROM repair_table")
    suspend fun deleteAllRepairs()
}