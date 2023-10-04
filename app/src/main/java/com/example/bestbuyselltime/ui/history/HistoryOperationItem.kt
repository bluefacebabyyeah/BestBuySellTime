package com.example.bestbuyselltime.ui.history

import com.example.bestbuyselltime.domain.models.Operation

data class HistoryOperationItem  (
    val operation: Operation,
    val onClick: (Operation) -> Unit
)