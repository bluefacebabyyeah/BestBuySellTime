package com.example.bestbuyselltime.di

import android.content.Context
import androidx.room.Room
import com.example.bestbuyselltime.data.AppDatabase
import com.example.bestbuyselltime.data.dao.CandleDao
import com.example.bestbuyselltime.data.dao.OperationDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideOperationDao(db: AppDatabase): OperationDao =
        db.getOperationDao()

    @Provides
    @Singleton
    fun provideCandlesDao(db: AppDatabase) : CandleDao =
        db.getCandleDao()
}