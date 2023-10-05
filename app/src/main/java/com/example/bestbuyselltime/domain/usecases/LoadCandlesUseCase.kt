package com.example.bestbuyselltime.domain.usecases

import com.example.bestbuyselltime.data.repo.CandleRepository
import com.example.bestbuyselltime.data.repo.OperationRepository
import com.example.bestbuyselltime.domain.models.Candle
import com.example.bestbuyselltime.domain.models.Operation
import javax.inject.Inject

class LoadCandlesUseCase @Inject constructor(
    private val candleRepository: CandleRepository
) {
    suspend fun insert(candle: Candle) {
        candleRepository.insert(candle)
    }
    suspend fun getList(): List<Candle> {
        return candleRepository.getAll()
    }
    suspend fun delete(candle: Candle){
       candleRepository.delete(candle)
    }
}