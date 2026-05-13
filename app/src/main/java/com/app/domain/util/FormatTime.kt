package com.app.domain.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatTime(timestamp: Long): String {
    val date = Date(timestamp)
    val format = SimpleDateFormat("dd.MM,HH:mm", Locale.getDefault())
    return format.format(date)
}