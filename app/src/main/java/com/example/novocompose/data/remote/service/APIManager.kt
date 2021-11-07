package com.example.novocompose.data.remote.service

import com.example.novocompose.data.remote.model.Customers
import com.example.novocompose.di.NetworkModule
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

object APIManager {

    private val service: APIService
    private val retrofit = NetworkModule.provideRetrofit()

    init {
        service = retrofit.create(APIService::class.java)
    }

    fun getLists(): Flow<List<Customers>> {
        return service.getLists()
    }

    suspend fun addCustomers(customers: Customers): Response<ResponseBody> {
        return service.addNewCustomer(customers)
    }

    suspend fun updateCustomer(customers: Customers) {
        service.updateExistingCustomer()
    }

}