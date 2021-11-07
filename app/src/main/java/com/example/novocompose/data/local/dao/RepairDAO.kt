package com.example.novocompose.data.local.dao

import androidx.room.*
import com.example.novocompose.data.local.entities.RepairList

@Dao
interface RepairDAO {

    // Get all Repairs
    @Query("Select * from repair_table Left Join vehicle_table on vehicle_id = vehicleID Group By vehicle_id")
    suspend fun getAllRepairs(): List<RepairList>

    // Get specific Repairs
    @Query("Select * from repair_table Left Join vehicle_table on vehicle_id = vehicleID Where vehicle_id = :vehicleID")
    suspend fun getVehicleRepairs(vehicleID: Int): RepairList

    // Insert new repair
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRepair(repair: RepairList): Int

    // Update repair status
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateRepair(repair: RepairList)
}