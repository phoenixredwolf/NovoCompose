package com.example.novocompose.data.local.dao

import androidx.room.*
import com.example.novocompose.data.local.entities.*
import com.example.novocompose.data.local.relations.CustomerVehicles
import com.example.novocompose.data.local.relations.MechanicsAssignedJobs
import com.example.novocompose.data.local.relations.VehicleListData
import kotlinx.coroutines.flow.Flow

@Dao
interface InspectionsDAO {

    // Acceleration Inspections
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAccelInsp(accel: AccelerationInsp): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAccelInsp(accel: AccelerationInsp)

    @Delete
    suspend fun deleteAccelInsp(accel: AccelerationInsp)

    @Query("DELETE from accel_table")
    suspend fun deleteAllAccelInsp()

    @Query("SELECT * from accel_table")
    fun getAllAccelInsp(): Flow<List<AccelerationInsp>>

    // Brake Inspections
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBrakeInsp(brake: BrakeInspection): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBrakeInsp(brake: BrakeInspection)

    @Delete
    suspend fun deleteBrakeInsp(brake: BrakeInspection)

    @Query("DELETE FROM brakes_table")
    suspend fun deleteAllBrakeInsp()

    @Query("SELECT * FROM brakes_table")
    fun getAllBrakeInsp(): Flow<List<BrakeInspection>>

    // Relational list queries
    @Transaction
    @Query("SELECT * FROM vehicle_table WHERE vehicle_id = :vehicleID")
    fun getVehicleListData(vehicleID: Long): Flow<List<VehicleListData>>

    @Transaction
    @Query("SELECT * FROM customer_table WHERE customer_id = :customerID")
    fun getCustomerVehicles(customerID: Long): Flow<List<CustomerVehicles>>

    @Transaction
    @Query("SELECT * FROM mechanic_table WHERE mech_id = :mechanicID")
    fun getMechanicsAssignedJobs(mechanicID: Long): Flow<List<MechanicsAssignedJobs>>

}