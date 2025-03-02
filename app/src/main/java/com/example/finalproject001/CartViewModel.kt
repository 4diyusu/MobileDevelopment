package com.example.finalproject001.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.data.ProductData

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<CartItem>()
    val cartItems: List<CartItem> get() = _cartItems

    fun addToCart(product: ProductData, quantity: Int) {
        val existingItem = _cartItems.find { it.product.id == product.id }
        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            _cartItems.add(CartItem(product, quantity))
        }
    }

    fun updateQuantity(productId: Int, quantity: Int) {
        val item = _cartItems.find { it.product.id == productId }
        if (item != null) {
            if (quantity > 0) {
                item.quantity = quantity
            } else {
                _cartItems.remove(item)
            }
        }
    }

    fun removeFromCart(productId: Int) {
        _cartItems.removeAll { it.product.id == productId }
    }
}
