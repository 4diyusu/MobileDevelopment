package com.example.finalproject001.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.data.ProductData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> get() = _cartItems

    fun addToCart(product: ProductData, quantity: Int) {
        val currentItems = _cartItems.value.toMutableList()
        val existingItem = currentItems.find { it.product.id == product.id }

        if (existingItem != null) {
            val updatedItem = existingItem.copy(quantity = existingItem.quantity + quantity)
            currentItems[currentItems.indexOf(existingItem)] = updatedItem
        } else {
            currentItems.add(CartItem(product, quantity))
        }

        _cartItems.value = currentItems // ✅ This ensures the cart updates

        Log.d("CartViewModel", "Added to cart: ${product.title}, Quantity: $quantity")
        Log.d("CartViewModel", "Cart now has: ${_cartItems.value.size} items")
    }

    fun updateQuantity(productId: Int, quantity: Int) {
        val currentItems = _cartItems.value.toMutableList()
        val itemIndex = currentItems.indexOfFirst { it.product.id == productId }

        if (itemIndex != -1) {
            if (quantity > 0) {
                currentItems[itemIndex] = currentItems[itemIndex].copy(quantity = quantity)
            } else {
                currentItems.removeAt(itemIndex)
            }
            _cartItems.value = currentItems
        }
    }

    fun removeFromCart(productId: Int) {
        _cartItems.value = _cartItems.value.filter { it.product.id != productId }
    }
}
