package com.example.bestbuyselltime

import android.os.Build
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

fun Long.formatAsDate(pattern: String): String {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.ROOT)
        val ldt = LocalDateTime.ofEpochSecond(this, 0, ZoneOffset.UTC)
        return ldt.format(formatter)
    } else {
        return ""
    }

}