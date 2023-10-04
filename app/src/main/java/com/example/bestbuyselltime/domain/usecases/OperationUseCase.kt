package com.example.bestbuyselltime.domain.usecases

import com.example.bestbuyselltime.data.repo.OperationRepository
import com.example.bestbuyselltime.domain.models.Operation
import javax.inject.Inject

class OperationUseCase @Inject constructor(
    private val operationRepository: OperationRepository
) {
    suspend fun insert(operation: Operation) {
        operationRepository.insert(operation)
    }
    suspend fun getList(): List<Operation> {
        return operationRepository.getAll()
    }
    suspend fun delete(operation: Operation){
        operationRepository.delete(operation)
    }
}