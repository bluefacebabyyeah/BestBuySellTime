package com.example.bestbuyselltime.ui.market

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestbuyselltime.domain.models.Candle
import com.example.bestbuyselltime.domain.models.Operation
import com.example.bestbuyselltime.domain.usecases.LoadCandlesUseCase
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Currency
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    private val getCandleUseCase: LoadCandlesUseCase,
    private val operationUseCase: OperationUseCase
) : ViewModel(){
    val candles = MutableLiveData<List<Candle>>(emptyList())
    val currentPrice = MutableLiveData<Double>()
    fun loadCandles(){
        candles.value = getCandleUseCase.getList()
        currentPrice.value = candles.value!!.last().newPrice
    }
    fun buy(price:Double, count: String) {
        viewModelScope.launch {
            operationUseCase.insert(
                Operation(
                    Operation.Type.Buy,
                    "usd",
                    price,
                    count.toDouble(),
                    Date()
                )
            )
        }
    }
}