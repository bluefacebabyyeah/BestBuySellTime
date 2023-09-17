package com.example.bestbuyselltime

import java.util.Currency
import java.util.Date

data class Operation (
    /* val type: Type,
    val currency: Currency,
    val price : Double,
    val ratio : Double,
    val sum : Double,
     */
    val date : Date

){
    enum class Type{
        Buy,
        Sell
    }
    constructor() : this(Date(System.currentTimeMillis()))
}