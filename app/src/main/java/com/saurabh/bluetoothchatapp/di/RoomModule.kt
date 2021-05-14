package com.saurabh.bluetoothchatapp.di

import android.content.Context
import androidx.room.Room
import com.saurabh.bluetoothchatapp.Constants.Companion.DATABASE_NAME
import com.saurabh.bluetoothchatapp.database.BCADatabase
import com.saurabh.bluetoothchatapp.database.MyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): BCADatabase {
        return Room.databaseBuilder(
            context, BCADatabase::class.java, DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(dataBase: BCADatabase): MyDao {
        return dataBase.myDao()
    }
}