package com.example.finalproject001.data

import com.google.firebase.Timestamp

data class Transaction(
    val transactionId: String = "",
    val totalPrice: Double = 0.0,
    val timestamp: Timestamp? = null
)
