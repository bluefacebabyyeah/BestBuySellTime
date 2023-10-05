package com.example.bestbuyselltime.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bestbuyselltime.data.dao.CandleDao
import com.example.bestbuyselltime.data.dao.OperationDao
import com.example.bestbuyselltime.data.models.CandleEntity
import com.example.bestbuyselltime.data.models.OperationEntity

@Database(
    entities = [
        OperationEntity::class,
        CandleEntity::class
    ],
    version = 3
)

abstract class AppDatabase:RoomDatabase() {
    abstract fun getOperationDao():OperationDao
    abstract fun getCandleDao():CandleDao
}