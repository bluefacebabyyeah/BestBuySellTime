package com.example.bestbuyselltime.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bestbuyselltime.data.models.OperationEntity

@Dao
interface OperationDao {
    @Query("select*from OperationEntity")
    fun getAll(): List<OperationEntity>

    @Insert
    fun insert(operationEntity: OperationEntity)

    @Delete
    fun delete(operationEntity: OperationEntity)

    @Query("select*from OperationEntity where date = :date")
    fun getByDate(date: Long): OperationEntity?
}