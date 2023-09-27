package com.example.bestbuyselltime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClosePositionViewModel(
    private val operationUseCase: OperationUseCase
) : ViewModel() {
    val operation = MutableLiveData<Operation>()
    fun loadOperation(loadOperation: Operation){
        operation.value = loadOperation
    }
    fun closeOperation(){
        operationUseCase.delete(operation.value!!)
    }
}