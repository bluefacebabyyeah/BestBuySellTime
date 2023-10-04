package com.example.bestbuyselltime.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bestbuyselltime.domain.models.Operation
import java.util.Currency
import java.util.Date

@Entity
data class OperationEntity(
    val type: String,
    val currency: String,
    val price: Double,
    val ratio: Double,
    val date: Long,
    @PrimaryKey(autoGenerate = true) val id:Int =0
) {
    fun toDomainModel() =
        Operation(
            type = Operation.Type.valueOf(type),
            currency = currency,
            price = price,
            ratio = ratio,
            date = Date(date)
        )
}