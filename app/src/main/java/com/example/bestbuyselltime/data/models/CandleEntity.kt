package com.example.bestbuyselltime.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bestbuyselltime.domain.models.Candle
import java.util.Date

@Entity
data class CandleEntity(
    val date: Long,
    val oldPrice: Double,
    val newPrice: Double,
    @PrimaryKey(autoGenerate = true) val id:Int =0
) {
    fun toDomainModel() =
        Candle(
            date = date,
            oldPrice = oldPrice,
            newPrice = newPrice,
        )

}
