package com.example.novocompose.di

import android.content.Context
import androidx.room.Room
import com.example.novocompose.data.local.MechDatabase
import com.example.novocompose.data.local.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideCustomerDAO(mechDatabase: MechDatabase): CustomerDAO {
        return mechDatabase.customerDao()
    }

    @Provides
    fun provideInspectionsDAO(mechDatabase: MechDatabase): InspectionsDAO {
        return mechDatabase.inspectionsDao()
    }

    @Provides
    fun provideMechanicDAO(mechDatabase: MechDatabase): MechanicDAO {
        return mechDatabase.mechanicDao()
    }

    @Provides
    fun provideRepairDAO(mechDatabase: MechDatabase): RepairDAO {
        return mechDatabase.repairDao()
    }

    @Provides
    fun provideVehicleDAO(mechDatabase: MechDatabase): VehicleDAO {
        return mechDatabase.vehicleDao()
    }

    @Provides
    @Singleton
    fun provideMechDatabase(@ApplicationContext appContext: Context): MechDatabase {
        return Room.databaseBuilder(
            appContext,
            MechDatabase::class.java,
            "mechdb"
        ).build()
    }
}