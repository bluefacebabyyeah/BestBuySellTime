package com.example.bestbuyselltime.ui.closeposition

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestbuyselltime.domain.models.Operation
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClosePositionViewModel @Inject constructor(
    private val operationUseCase: OperationUseCase
) : ViewModel() {
    val operation = MutableLiveData<Operation>()
    fun loadOperation(loadOperation: Operation){
        operation.value = loadOperation
    }
    fun closeOperation(){
        viewModelScope.launch {
            operationUseCase.delete(operation.value!!)
        }
    }
}