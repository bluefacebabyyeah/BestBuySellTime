package com.example.bestbuyselltime.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bestbuyselltime.data.models.CandleEntity
import com.example.bestbuyselltime.data.models.OperationEntity

@Dao
interface CandleDao {
    @Query("select*from CandleEntity")
    fun getAll(): List<CandleEntity>

    @Insert
    fun insert(candleEntity: CandleEntity)

    @Delete
    fun delete(candleEntity: CandleEntity)

    @Query("select*from CandleEntity where date = :date")
    fun getByDate(date: Long): CandleEntity?
}