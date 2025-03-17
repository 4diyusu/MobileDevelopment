package com.example.finalproject001.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.finalproject001.data.CartItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.Product
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    fun addToCart(product: Product, quantity: Int) {
        val currentCart = _cartItems.value.toMutableList()
        val existingItem = currentCart.find { it.id == product.id }

        if (existingItem != null) {
            currentCart.remove(existingItem)
            currentCart.add(existingItem.copy(quantity = existingItem.quantity + quantity))
        } else {
            currentCart.add(CartItem(product.id, product.name, product.price, quantity))
        }

        _cartItems.value = currentCart
    }

    fun updateQuantity(cartItem: CartItem, newQuantity: Int) {
        val currentCart = _cartItems.value.toMutableList()
        val index = currentCart.indexOfFirst { it.id == cartItem.id }

        if (index != -1) {
            val updatedItem = cartItem.copy(quantity = newQuantity)
            currentCart[index] = updatedItem
            _cartItems.value = currentCart
        }
    }

    fun removeFromCart(cartItem: CartItem) {
        val updatedCart = _cartItems.value.filter { it.id != cartItem.id }
        _cartItems.value = updatedCart
    }

    fun clearCart() {
        _cartItems.value = emptyList()
    }
}

