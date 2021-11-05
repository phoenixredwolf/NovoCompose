package com.example.novocompose.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.novocompose.data.local.entities.RepairList

@Dao
interface RepairDAO {

    // Get all Repairs
    @Query("Select * from repair_table Left Join vehicle_table on vehicle_id = vehicleID Group By vehicle_id")
    suspend fun getAllRepairs(): List<RepairList>

    // Get sepcific Repairs
    @Query("Select * from repair_table Left Join vehicle_table on vehicle_id = vehicleID Where vehicle_id = :vehicleID")
    suspend fun getVehicleRepairs(vehicleID: Long): RepairList
}