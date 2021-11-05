package com.example.novocompose.data.local

import android.app.Application
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.novocompose.data.local.entities.*

@Database(  entities = [    Vehicle::class,
                            Customer::class,
                            AccelerationInsp::class,
                            BrakeInspection::class,
                            RepairList::class],
            version = 1)
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
}