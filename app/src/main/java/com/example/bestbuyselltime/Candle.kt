package com.example.bestbuyselltime

import java.time.LocalDateTime
import java.util.Date

data class Candle (
    val date: Long,
    val oldPrice: Double,
    val newPrice: Double
)
