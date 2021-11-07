package com.example.novocompose.data.local.dao

import androidx.room.*
import com.example.novocompose.data.local.entities.*
import com.example.novocompose.data.local.relations.CustomerVehicles
import com.example.novocompose.data.local.relations.MechanicsAssignedJobs
import com.example.novocompose.data.local.relations.VehicleListData

interface InspectionsDAO {

    // Acceleration Inspections
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAccelInsp(accel: AccelerationInsp): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAccelInsp(accel: AccelerationInsp)

    @Delete
    suspend fun deleteAccelInsp(accelID: Int)

    @Query("DELETE from accel_insp")
    suspend fun deleteAllAccelInsp()

    // Brake Inspections
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBrakeInsp(brake: BrakeInspection): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBrakeInsp(brake: BrakeInspection)

    @Delete
    suspend fun deleteBrakeInsp(brakeID: Int)

    @Query("DELETE FROM brakes_table")
    suspend fun deleteAllBrakeInsp()

    // Relational list queries
    @Transaction
    @Query("SELECT * FROM vehicle_table WHERE vehicle_id = :vehicleID")
    suspend fun getVehicleListData(vehicleID: Int): List<VehicleListData>

    @Transaction
    @Query("SELECT * FROM customer_table WHERE customer_id = :customerID")
    suspend fun getCustomerVehicles(customerID: Int): List<CustomerVehicles>

    @Transaction
    @Query("SELECT * FROM mechanic_table WHERE mechanic_id = :mechanicID")
    suspend fun getMechanicsAssignedJobs(mechanicID: Int): List<MechanicsAssignedJobs>

}