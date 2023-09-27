package com.example.bestbuyselltime

import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick

data class OperationHistoryItem  (
    val operation: Operation,
    val onClick: (Operation) -> Unit
)