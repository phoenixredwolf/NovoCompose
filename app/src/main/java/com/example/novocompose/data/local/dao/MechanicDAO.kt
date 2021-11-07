package com.example.novocompose.data.local.dao

import androidx.room.*
import com.example.novocompose.data.local.entities.Mechanic

interface MechanicDAO {

    // Insert new mechanic
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMechanic(mechanic: Mechanic): Int

    // Update mechanic
    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateMechanic(mechanic: Mechanic)

    // Get all mechanics
    @Query("Select * from mechanic_table")
    suspend fun getAllMechanics(): List<Mechanic>

    // Get specific mechanic
    @Query("Select * from mechanic_table where last_name = :lastName and first_name = :firstName")
    suspend fun getMechanic(lastName: String, firstName: String): Mechanic

    // Delete specific mechanic
    @Delete
    suspend fun deleteMechanic(mechanic: Mechanic)

    // Delete all customers
    @Query("Delete from mechanic_table")
    suspend fun deleteAllMechanics(): Unit
}