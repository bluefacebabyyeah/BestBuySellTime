package com.example.bestbuyselltime.data.repo

import com.example.bestbuyselltime.data.dao.CandleDao
import com.example.bestbuyselltime.data.models.CandleEntity
import com.example.bestbuyselltime.data.models.OperationEntity
import com.example.bestbuyselltime.domain.models.Candle
import com.example.bestbuyselltime.domain.models.Operation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CandleRepository @Inject constructor(
    private val dao: CandleDao
){
    suspend fun getAll(): List<Candle>{
        return withContext(Dispatchers.IO){
            dao.getAll().map {
                it.toDomainModel()
            }
        }
    }
    suspend fun insert(candle: Candle){
        withContext(Dispatchers.IO) {
            dao.insert(
                CandleEntity(
                    date = candle.date,
                    newPrice = candle.newPrice,
                    oldPrice = candle.oldPrice,
                )
            )
        }
    }
    suspend fun delete(candle: Candle){
        withContext(Dispatchers.IO){
            val entity = dao.getByDate(candle.date)?:return@withContext
            dao.delete(entity)
        }
    }
}