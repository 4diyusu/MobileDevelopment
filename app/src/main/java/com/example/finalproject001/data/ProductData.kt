package com.example.finalproject001.data

data class ProductData(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val productImageId: Int = 0
)