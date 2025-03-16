package com.example.finalproject001.data

data class Product(
    val id: String = "",       // Firestore auto-generated ID
    val name: String = "",
    val price: Double = 0.0,
    val details: String = "",
    val imgUrl: String = ""   // Stores image URL (e.g., Imgur, Firebase Storage)
)
