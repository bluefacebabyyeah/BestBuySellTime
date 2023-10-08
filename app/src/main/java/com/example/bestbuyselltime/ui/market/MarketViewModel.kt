package com.example.bestbuyselltime.ui.market

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bestbuyselltime.domain.models.Candle
import com.example.bestbuyselltime.domain.models.Operation
import com.example.bestbuyselltime.domain.usecases.GetCandlesUseCase
import com.example.bestbuyselltime.domain.usecases.LoadFreshCandleUseCase
import com.example.bestbuyselltime.domain.usecases.OperationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MarketViewModel @Inject constructor(
    private val getCandleUseCase: GetCandlesUseCase,
    private val loadFreshCandleUseCase: LoadFreshCandleUseCase,
    private val operationUseCase: OperationUseCase
) : ViewModel(){
    val candles = MutableLiveData<List<Candle>>(emptyList())
    val currentPrice = MutableLiveData<Double>()
    fun loadCandles(){
        viewModelScope.launch {
            loadFreshCandleUseCase.loadFreshCandle()
            candles.value = getCandleUseCase.getList()
            currentPrice.value = candles.value!!.lastOrNull()?.newPrice
        }
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