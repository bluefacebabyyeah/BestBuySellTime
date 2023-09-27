package com.example.bestbuyselltime

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Currency
import java.util.Date
import java.util.Locale

class MarketViewModel(
    private val getCandleUseCase:LoadCandlesUseCase,
    private val operationUseCase: OperationUseCase
) : ViewModel(){
    val candles = MutableLiveData<List<Candle>>(emptyList())
    val currentPrice = MutableLiveData<Double>()
    fun loadCandles(){
        candles.value = getCandleUseCase.getList()
        currentPrice.value = candles.value!!.last().newPrice
    }
    fun buy(price:Double, count: String) {
        operationUseCase.add(Operation(Operation.Type.Buy,
            Currency.getInstance(Locale.US),price, count.toDouble(), Date()
        ))
    }
}