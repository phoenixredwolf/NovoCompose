package com.example.novocompose.data.repo

import com.example.novocompose.data.local.MechDatabase
import com.example.novocompose.data.local.entities.AccelerationInsp
import com.example.novocompose.data.local.entities.Customer
import com.example.novocompose.data.local.entities.Mechanic
import com.example.novocompose.data.local.entities.Vehicle
import javax.inject.Inject

class DataRepo @Inject constructor(mechdb: MechDatabase) {

    val db = mechdb

    private val customerDAO by lazy { mechdb.customerDao() }

    private val inspectionsDAO by lazy { mechdb.inspectionsDao() }

    private val mechanicDAO by lazy { mechdb.mechanicDao() }

    private val repairDAO by lazy { mechdb.repairDao() }

    private val vehicleDAO by lazy { mechdb.vehicleDao() }

    // Customer Functions
    suspend fun getAllCustomers(): List<Customer> { return customerDAO.getAllCustomers() }

    suspend fun getCustomer(lastName: String, firstName: String): Customer {
        return customerDAO.getCustomer(lastName, firstName)
    }

    suspend fun insertCustomer(customer: Customer): Int { return customerDAO.insertCustomer(customer) }

    suspend fun updateCustomer(customer: Customer) { customerDAO.updateCustomer(customer) }

    suspend fun deleteCustomer(customer: Customer){ customerDAO.deleteCustomer(customer) }

    suspend fun deleteAllCustomers() { customerDAO.deleteAllCustomers() }

    // Vehicle Functions
    suspend fun getAllVehicles(): List<Vehicle> { return vehicleDAO.getAllVehicles() }

    suspend fun getVehicle(vehicleID: Int): Vehicle { return vehicleDAO.getVehicle(vehicleID) }

    suspend fun insertVehicle(vehicle: Vehicle): Int { return vehicleDAO.insertVehicle(vehicle) }

    suspend fun updateVehicle(vehicle: Vehicle) { vehicleDAO.updateVehicle(vehicle) }

    suspend fun deleteVehicle(vehicle: Vehicle) { vehicleDAO.deleteVehicle(vehicle) }

    suspend fun deleteAllVehicles() { vehicleDAO.deleteAllVehicles() }

    // Mechanic Functions
    suspend fun insertMechanic(mechanic: Mechanic): Int { return mechanicDAO.insertMechanic(mechanic) }

    suspend fun getMechanic(lastName: String, firstName: String): Mechanic {
        return mechanicDAO.getMechanic(lastName, firstName)
    }

    suspend fun getAllMechanics(): List<Mechanic> { return mechanicDAO.getAllMechanics() }

    suspend fun updateMechanic(mechanic: Mechanic) { mechanicDAO.updateMechanic(mechanic) }

    suspend fun deleteMechanic(mechanic: Mechanic) { mechanicDAO.deleteMechanic(mechanic) }

    suspend fun deleteAllMechanics() { mechanicDAO.deleteAllMechanics() }

    // Inspection Functions
    suspend fun insertAccelInsp(accelInsp: AccelerationInsp): Int {
        return inspectionsDAO.insertAccelInsp(accelInsp) }

    suspend fun updateAccelInsp(accelInsp: AccelerationInsp) { inspectionsDAO.updateAccelInsp(accelInsp)}

    suspend fun deleteAccelInsp(accelID: Int) { inspectionsDAO.deleteAccelInsp(accelID) }

    suspend fun deleteAllAccelInsp() { inspectionsDAO.deleteAllAccelInsp() }
}