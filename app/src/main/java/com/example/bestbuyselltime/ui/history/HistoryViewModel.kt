package com.example.bestbuyselltime.ui.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestbuyselltime.domain.models.Operation
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val operationUseCase: OperationUseCase
) : ViewModel() {
    val operations = MutableLiveData<List<HistoryOperationItem>>(emptyList())
    val lastClickedItem = MutableLiveData<Operation?>()
    fun loadOperations(){
        viewModelScope.launch {
            operations.value = operationUseCase.getList().map{ HistoryOperationItem(
                it
            ) {
                lastClickedItem.value = it
                lastClickedItem.value = null
                }
            }
        }
    }
}