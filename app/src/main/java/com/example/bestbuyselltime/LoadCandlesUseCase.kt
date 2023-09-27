package com.example.bestbuyselltime

class LoadCandlesUseCase {
    fun getList() = listOf(
        Candle(1,1.0,2.0),
        Candle(2,2.0,3.0),
        Candle(3,4.0,5.0),
        Candle(4,5.0,6.0),
        Candle(5,6.0,7.0),
        Candle(6,7.0,8.0),
        Candle(7,8.0,9.0)
    )
}