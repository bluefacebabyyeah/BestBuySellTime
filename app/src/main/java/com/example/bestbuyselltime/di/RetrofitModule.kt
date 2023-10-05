package com.example.bestbuyselltime.di

import com.example.bestbuyselltime.data.api.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    companion object {
        const val API_URL = "http://api.currencylayer.com/"
        const val API_KEY = "6478afa365547e05d1bcb6237a6cd810"
    }

    @Provides
    fun provideApi() =
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyApi::class.java)
}
