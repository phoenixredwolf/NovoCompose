package com.example.novocompose.data.remote.service

import com.example.novocompose.data.remote.model.Customers
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface APIService {

    // Gets all documents from the database
    // Could limit based on date or other factors
    @GET("extension for a NoSQL database")
    fun getLists(): Flow<List<Customers>>

    @POST("extension for adding new customer data")
    suspend fun addNewCustomer(@Body customers: Customers): Response<ResponseBody>

    @PUT("extension to update document")
    suspend fun updateExistingCustomer() // this method would need a longer definition
}