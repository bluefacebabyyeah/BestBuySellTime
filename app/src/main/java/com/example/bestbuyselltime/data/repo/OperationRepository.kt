package com.example.bestbuyselltime.data.repo

import com.example.bestbuyselltime.data.dao.OperationDao
import com.example.bestbuyselltime.data.models.OperationEntity
import com.example.bestbuyselltime.domain.models.Operation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OperationRepository @Inject constructor(
    private val dao: OperationDao
){
    suspend fun getAll(): List<Operation>{
        return withContext(Dispatchers.IO){
            dao.getAll().map {
                it.toDomainModel()
            }
        }
    }
    suspend fun insert(operation: Operation){
        withContext(Dispatchers.IO) {
            dao.insert(
                OperationEntity(
                    type = operation.type.name,
                    currency = operation.currency,
                    price = operation.price,
                    ratio = operation.ratio,
                    date = operation.date.time
                )
            )
        }
    }
    suspend fun delete(operation: Operation){
        withContext(Dispatchers.IO){
            val entity = dao.getByDate(operation.date.time)?:return@withContext
            dao.delete(entity)
        }
    }
}