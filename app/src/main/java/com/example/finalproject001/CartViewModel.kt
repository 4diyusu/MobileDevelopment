package com.example.finalproject001.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.data.ProductData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems = _cartItems.asStateFlow()

    fun addToCart(product: ProductData, quantity: Int) {
        val updatedCart = _cartItems.value.toMutableList()
        val existingItem = updatedCart.find { it.product.id == product.id }

        if (existingItem != null) {
            val updatedItem = existingItem.copy(quantity = existingItem.quantity + quantity)
            updatedCart[updatedCart.indexOf(existingItem)] = updatedItem
        } else {
            updatedCart.add(CartItem(product, quantity))
        }

        _cartItems.value = updatedCart
        println("Cart Updated: ${_cartItems.value.size} items")
    }

    fun updateQuantity(product: ProductData, newQuantity: Int) {
        val currentItems = _cartItems.value.toMutableList()
        val item = currentItems.find { it.product.id == product.id }
        if (item != null) {
            item.quantity = newQuantity
            _cartItems.value = currentItems
        }
    }

    fun removeFromCart(product: ProductData) {
        _cartItems.value = _cartItems.value.filter { it.product.id != product.id }
    }
}
