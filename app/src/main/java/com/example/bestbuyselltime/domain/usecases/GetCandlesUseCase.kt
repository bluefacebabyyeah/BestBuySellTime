package com.example.bestbuyselltime.domain.usecases

import com.example.bestbuyselltime.data.repo.CandleRepository
import com.example.bestbuyselltime.domain.models.Candle
import javax.inject.Inject

class GetCandlesUseCase @Inject constructor(
    private val candleRepository: CandleRepository
) {
    suspend fun getList(): List<Candle> {
        return candleRepository.getAll()
    }
}