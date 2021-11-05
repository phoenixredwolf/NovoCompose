package com.example.novocompose.data.local.dao

import androidx.room.*
import com.example.novocompose.data.local.entities.Customer

@Dao
interface CustomerDAO {

    // Get all
    @Query("Select * from customer_table")
    suspend fun getAllCustomers(): List<Customer>

    // Get specific customer
    @Query("Select * from customer_table where last_name = :lastName and first_name = :firstName")
    suspend fun getCustomer(lastName: String, firstName: String): Customer

    // Delete specific customer
    @Delete
    suspend fun deleteCustomer(vararg customer: Customer)

    // Delete all customers
    @Query("Delete from customer_table")
    suspend fun deleteAllCustomers(): Unit

    // Insert new customer
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewCustomer(vararg customer: Customer)
}