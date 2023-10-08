package com.example.bestbuyselltime.data.api

import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    val success: Boolean,
    val timestamp: Long,
    val source: String,
    val quotes: Quotes,
) {
    data class Quotes (
        @SerializedName("USDRUB") val usdRub: Double,
    )
}