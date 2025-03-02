package com.example.finalproject001.data

data class CartItem(
    val product: ProductData,
    var quantity: Int,
){
    val totalPrice: Double
        get() = product.price * quantity
}
