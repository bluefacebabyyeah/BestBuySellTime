package com.example.bestbuyselltime.domain.models

import java.io.Serializable
import java.util.Currency
import java.util.Date

data class Operation (
    val type: Type,
    val currency: String,
    val price : Double,
    val ratio : Double,
    val date : Date

) : Serializable {
    val sum = price*ratio
    enum class Type{
        Buy,
        Sell
    }
}