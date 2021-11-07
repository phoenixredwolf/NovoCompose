package com.example.novocompose.data.local

import android.app.Application
import android.content.Context
import androidx.room.*
import com.example.novocompose.data.local.dao.*
import com.example.novocompose.data.local.entities.*
import com.example.novocompose.data.local.util.Converters

@Database(  entities = [    Vehicle::class,
                            Customer::class,
                            AccelerationInsp::class,
                            BrakeInspection::class,
                            RepairList::class,
                            Mechanic::class],
            version = 1)
@TypeConverters(Converters::class)
abstract class MechDatabase: RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: MechDatabase? = null

        fun getDatabase(context: Context): MechDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MechDatabase::class.java,
                    "mechdb"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

    abstract fun customerDao(): CustomerDAO
    abstract fun inspectionsDao(): InspectionsDAO
    abstract fun mechanicDao(): MechanicDAO
    abstract fun repairDao(): RepairDAO
    abstract fun vehicleDao(): VehicleDAO

}