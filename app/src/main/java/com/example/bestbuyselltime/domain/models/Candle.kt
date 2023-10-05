package com.example.bestbuyselltime.domain.models

import java.util.Date

data class Candle(
    val date : Long,
    val oldPrice: Double,
    val newPrice: Double,
)
{
    val diffPrice = newPrice-oldPrice
    val diffPricePercent = diffPrice*100/oldPrice
}