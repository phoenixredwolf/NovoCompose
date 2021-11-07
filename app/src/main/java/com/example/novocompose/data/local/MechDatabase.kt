package com.example.novocompose.data.local

import android.app.Application
import androidx.room.*
import com.example.novocompose.data.local.dao.*
import com.example.novocompose.data.local.entities.*
import com.example.novocompose.data.local.util.Converters

@Database(  entities = [    Vehicle::class,
                            Customer::class,
                            AccelerationInsp::class,
                            BrakeInspection::class,
                            RepairList::class],
            version = 1)
@TypeConverters(Converters::class)
abstract class MechDatabase: RoomDatabase() {

    companion object {

        private const val DB_Name = "mechanic.db"
        private lateinit var application: Application
        private val database: MechDatabase by lazy(LazyThreadSafetyMode.SYNCHRONIZED){
            Room.databaseBuilder(application, MechDatabase::class.java, DB_Name).build()
        }

        fun getDatabase(application: Application): MechDatabase {
            this.application = application
            return database
        }
    }

    abstract fun customerDao(): CustomerDAO
    abstract fun inspectionsDao(): InspectionsDAO
    abstract fun mechanicDao(): MechanicDAO
    abstract fun repairDao(): RepairDAO
    abstract fun vehicleDao(): VehicleDAO

}