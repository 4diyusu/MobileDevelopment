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
import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems
    val totalPrice = cartItems.map { cartList ->
        cartList.sumOf { it.price * it.quantity }
    }.stateIn(viewModelScope, SharingStarted.Lazily, 0.0)


    fun addToCart(item: CartItem) {
        _cartItems.value = _cartItems.value + item
    }

    fun updateQuantity(id: Int, newQuantity: Int) {
        _cartItems.value = _cartItems.value.map {
            if (it.id.toInt() == id) it.copy(quantity = newQuantity) else it
        }
    }

    fun removeFromCart(id: Int) {
        _cartItems.value = _cartItems.value.filter { it.id.toInt() != id }
    }

    fun clearCart() {
        _cartItems.value = emptyList() // Set cart items to an empty list
    }
}


