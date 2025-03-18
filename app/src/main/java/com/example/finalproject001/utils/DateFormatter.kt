package com.example.finalproject001.utils

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

fun formatTimestamp(timestamp: Timestamp?): String {
    return timestamp?.toDate()?.let { date ->
        SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(date)
    } ?: "Unknown Date"
}
