package com.example.novocompose.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.novocompose.data.local.entities.*
import com.example.novocompose.data.repo.DataRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(repo: DataRepo) : ViewModel() {

    var carID: Int = 0
    var mechID: Int = 0
    var vehicleID: Int = 0
    val dataRepo = repo

    // Mutable LiveData
    private val _accelList = MutableLiveData<List<AccelerationInsp>>()
    val _brakeList = MutableLiveData<List<BrakeInspection>>()
    val _repairList = MutableLiveData<List<RepairList>>()
    val _customerList = MutableLiveData<List<Customer>>()
    val _vehichleList = MutableLiveData<List<Vehicle>>()

    // Observable Livedata
    val accelList: LiveData<List<AccelerationInsp>> get() = _accelList
    val brakeList: LiveData<List<BrakeInspection>> get() = _brakeList
    val repairList: LiveData<List<RepairList>> get() = _repairList
    val customerList: LiveData<List<Customer>> get() = _customerList
    val vehicleList: LiveData<List<Vehicle>> get() = _vehichleList

    // Get All Functions
    fun getAccelList() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepo.getAllAccelInsp().collect { _accelList.postValue(it) }
        }
    }

    fun getBrakeList() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepo.getAllBrakeInsp().collect { _brakeList.postValue(it) }
        }
    }

    fun getRepairList() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepo.getAllRepairs().collect { _repairList.postValue(it) }
        }
    }

    fun getCustomerList() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepo.getAllCustomers().collect { _customerList.postValue(it) }
        }
    }

    fun getVehicleList() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepo.getAllVehicles().collect { _vehichleList.postValue(it) }
        }
    }


}