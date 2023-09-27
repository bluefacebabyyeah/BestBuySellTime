package com.example.bestbuyselltime

object OperationUseCase {
    private val operationList = mutableListOf<Operation>()
    fun add(operation: Operation) {
        operationList.add(operation)
    }
    fun getList(): MutableList<Operation> {
        return operationList
    }
    fun delete(operation: Operation){
        operationList.remove(operation)
    }
}