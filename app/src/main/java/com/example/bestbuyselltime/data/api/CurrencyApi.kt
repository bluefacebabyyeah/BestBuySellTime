package com.example.bestbuyselltime.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("live")
    suspend fun getLiveCurrencies(@Query("access_key") apiKey: String):
            CurrencyDto
}