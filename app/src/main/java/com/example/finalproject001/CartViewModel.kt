package com.example.finalproject001.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.data.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun addToCart(product: ProductData, quantity: Int) {
        viewModelScope.launch {
            val currentCart = _cartItems.value.toMutableList()
            val existingItem = currentCart.find { it.product.id == product.id }

            if (existingItem != null) {
                existingItem.quantity += quantity
            } else {
                currentCart.add(CartItem(product, quantity))
            }

            _cartItems.value = currentCart
            Log.d("CartViewModel", "Added to cart: ${product.title} - Qty: $quantity")
            Log.d("CartViewModel", "Cart now has ${_cartItems.value.size} items")
        }
    }

    fun updateQuantity(productId: Int, quantity: Int) {
        viewModelScope.launch {
            val currentItems = _cartItems.value.toMutableList()
            val itemIndex = currentItems.indexOfFirst { it.product.id == productId }

            if (itemIndex != -1) {
                if (quantity > 0) {
                    currentItems[itemIndex] = currentItems[itemIndex].copy(quantity = quantity)
                } else {
                    currentItems.removeAt(itemIndex)
                }
                _cartItems.value = currentItems.toList()
            }
        }
    }

    fun removeFromCart(productId: Int) {
        viewModelScope.launch {
            _cartItems.value = _cartItems.value.filter { it.product.id != productId }
        }
    }
}
