package com.example.bestbuyselltime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoryViewModel(
    private val operationUseCase: OperationUseCase
) : ViewModel() {
    val operations = MutableLiveData<List<OperationHistoryItem>>(emptyList())
    val lastClickedItem = MutableLiveData<Operation?>()
    fun loadOperations(){
        operations.value = operationUseCase.getList().map{ OperationHistoryItem(
            it,
            {lastClickedItem.value = it
                lastClickedItem.value = null
            })
        }
    }
}