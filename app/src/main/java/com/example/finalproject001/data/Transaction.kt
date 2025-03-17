package com.example.finalproject001.data

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

data class Transaction(
    val id: String = "",
    val timestamp: Timestamp? = null, // Firestore timestamp (previously date)
    val totalAmount: Double = 0.0,
    val products: List<TransactionProduct> = emptyList()
) {
    fun formattedDate(): String {
        return timestamp?.toDate()?.let {
            SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(it)
        } ?: "No Date"
    }
}


data class TransactionProduct(
    val id: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val totalPrice: Double
)


