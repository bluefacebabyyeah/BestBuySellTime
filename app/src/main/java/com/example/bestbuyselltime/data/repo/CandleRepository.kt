package com.example.bestbuyselltime.data.repo

import com.example.bestbuyselltime.data.api.CurrencyApi
import com.example.bestbuyselltime.data.dao.CandleDao
import com.example.bestbuyselltime.data.models.CandleEntity
import com.example.bestbuyselltime.data.models.OperationEntity
import com.example.bestbuyselltime.di.RetrofitModule
import com.example.bestbuyselltime.domain.models.Candle
import com.example.bestbuyselltime.domain.models.Operation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CandleRepository @Inject constructor(
    private val dao: CandleDao,
    private val api: CurrencyApi
){
    suspend fun getAll(): List<Candle>{
        return withContext(Dispatchers.IO){
            dao.getAll().map {
                it.toDomainModel()
            }
        }
    }
    suspend fun loadFreshCandle(){
        withContext(Dispatchers.IO) {
            val dto = api.getLiveCurrencies(RetrofitModule.API_KEY)
            val candle = Candle(
                date = dto.timestamp,
                oldPrice = dao.getAll().maxByOrNull{
                    it.date
                }?.newPrice
                    ?:0.0,
                newPrice = dto.quotes.usdRub
            )
            dao.insert(
                CandleEntity(
                    date = candle.date,
                    newPrice = candle.newPrice,
                    oldPrice = candle.oldPrice,
                )
            )
        }
    }
}