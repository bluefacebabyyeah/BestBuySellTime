package com.example.bestbuyselltime.domain.usecases

import com.example.bestbuyselltime.data.repo.CandleRepository
import javax.inject.Inject

class LoadFreshCandleUseCase @Inject constructor(
    private val candleRepository : CandleRepository
) {
    suspend fun loadFreshCandle() {
        candleRepository.loadFreshCandle()
    }
}