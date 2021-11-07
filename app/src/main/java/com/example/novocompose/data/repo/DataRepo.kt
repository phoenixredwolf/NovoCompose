package com.example.novocompose.data.repo

import com.example.novocompose.data.local.MechDatabase
import com.example.novocompose.data.local.entities.*
import com.example.novocompose.data.local.relations.CustomerVehicles
import com.example.novocompose.data.local.relations.MechanicsAssignedJobs
import com.example.novocompose.data.local.relations.VehicleListData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataRepo {

    @Inject lateinit var mechdb: MechDatabase
    var customerID: Long = 0L
    var mechID: Long = 0L
    var vehicleID: Long = 0L

    // Get DAOs from Database
    private val customerDAO by lazy { mechdb.customerDao() }
    private val inspectionsDAO by lazy { mechdb.inspectionsDao() }
    private val mechanicDAO by lazy { mechdb.mechanicDao() }
    private val repairDAO by lazy { mechdb.repairDao() }
    private val vehicleDAO by lazy { mechdb.vehicleDao() }

    // Detail lists
    val allCustomerVehicles: Flow<List<CustomerVehicles>> = inspectionsDAO.getCustomerVehicles(customerID)
    val allAssignedJobs: Flow<List<MechanicsAssignedJobs>> = inspectionsDAO.getMechanicsAssignedJobs(mechID)
    val allLists: Flow<List<VehicleListData>> = inspectionsDAO.getVehicleListData(vehicleID)

    // Individual data
    suspend fun getCustomer(lastName: String, firstName: String): Customer {
        return customerDAO.getCustomer(lastName, firstName)
    }
    suspend fun getVehicle(vehicleID: Long): Vehicle { return vehicleDAO.getVehicle(vehicleID) }
    suspend fun getMechanic(lastName: String, firstName: String): Mechanic {
        return mechanicDAO.getMechanic(lastName, firstName)
    }

    // Individual lists
    fun getAllCustomers(): Flow<List<Customer>> { return customerDAO.getAllCustomers() }
    fun getAllVehicles(): Flow<List<Vehicle>> { return vehicleDAO.getAllVehicles() }
    suspend fun getAllMechanics(): List<Mechanic> { return mechanicDAO.getAllMechanics() }
    fun getAllBrakeInsp(): Flow<List<BrakeInspection>> { return inspectionsDAO.getAllBrakeInsp() }
    fun getAllAccelInsp(): Flow<List<AccelerationInsp>> { return inspectionsDAO.getAllAccelInsp() }
    fun getAllRepairs(): Flow<List<RepairList>> { return repairDAO.getAllRepairs() }

    // Inserts
    suspend fun insertCustomer(customer: Customer): Long { return customerDAO.insertCustomer(customer) }
    suspend fun insertVehicle(vehicle: Vehicle): Long { return vehicleDAO.insertVehicle(vehicle) }
    suspend fun insertMechanic(mechanic: Mechanic): Long { return mechanicDAO.insertMechanic(mechanic) }
    suspend fun insertAccelInsp(accelInsp: AccelerationInsp): Long {
        return inspectionsDAO.insertAccelInsp(accelInsp) }
    suspend fun insertBrakeInsp(brakeInsp: BrakeInspection): Long {
        return inspectionsDAO.insertBrakeInsp(brakeInsp)
    }
    suspend fun insertRepair(repair: RepairList): Long { return repairDAO.insertRepair(repair) }

    // Updates
    suspend fun updateCustomer(customer: Customer) { customerDAO.updateCustomer(customer) }
    suspend fun updateVehicle(vehicle: Vehicle) { vehicleDAO.updateVehicle(vehicle) }
    suspend fun updateMechanic(mechanic: Mechanic) { mechanicDAO.updateMechanic(mechanic) }
    suspend fun updateAccelInsp(accelInsp: AccelerationInsp) { inspectionsDAO.updateAccelInsp(accelInsp) }
    suspend fun updateBrakeInsp(brakeInsp: BrakeInspection) { inspectionsDAO.updateBrakeInsp(brakeInsp) }
    suspend fun updateRepair(repair: RepairList) { repairDAO.updateRepair(repair) }

    // Delete Individual
    suspend fun deleteCustomer(customer: Customer){ customerDAO.deleteCustomer(customer) }
    suspend fun deleteVehicle(vehicle: Vehicle) { vehicleDAO.deleteVehicle(vehicle) }
    suspend fun deleteMechanic(mechanic: Mechanic) { mechanicDAO.deleteMechanic(mechanic) }
    suspend fun deleteAccelInsp(accelInsp: AccelerationInsp) { inspectionsDAO.deleteAccelInsp(accelInsp) }
    suspend fun deleteBrakeInsp(brakeInsp: BrakeInspection) { inspectionsDAO.deleteBrakeInsp(brakeInsp) }
    suspend fun deleteRepair(repair: RepairList) { repairDAO.deleteRepair(repair) }

    // Delete All
    suspend fun deleteAllCustomers() { customerDAO.deleteAllCustomers() }
    suspend fun deleteAllVehicles() { vehicleDAO.deleteAllVehicles() }
    suspend fun deleteAllMechanics() { mechanicDAO.deleteAllMechanics() }
    suspend fun deleteAllAccelInsp() { inspectionsDAO.deleteAllAccelInsp() }
    suspend fun deleteAllRepairs() { repairDAO.deleteAllRepairs() }

}