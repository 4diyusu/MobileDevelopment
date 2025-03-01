package com.example.finalproject001.data

import androidx.annotation.DrawableRes
import java.io.Serializable

data class ProductData(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    @DrawableRes val productImageId: Int
) : Serializable