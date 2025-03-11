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
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CartViewModel(application: Application) : AndroidViewModel(application) {
    private val _cartItems = MutableLiveData<List<CartItem>>(emptyList())
    val cartItems: LiveData<List<CartItem>> = _cartItems

    fun addToCart(product: ProductData) {
        val currentItems = _cartItems.value.orEmpty().toMutableList()
        val existingItem = currentItems.find { it.productName == product.title }

        if (existingItem != null) {
            // Update existing quantity
            val updatedItems = currentItems.map {
                if (it.productName == product.title) it.copy(quantity = it.quantity + 1)
                else it
            }
            _cartItems.value = updatedItems
        } else {
            // Add new item
            _cartItems.value = currentItems + CartItem(productName = product.title, quantity = 1)
        }
    }

    fun updateQuantity(productName: String, newQuantity: Int) {
        val currentItems = _cartItems.value.orEmpty().toMutableList()
        val updatedItems = currentItems.map {
            if (it.productName == productName) it.copy(quantity = newQuantity) else it
        }
        _cartItems.value = updatedItems
    }

    fun removeFromCart(productName: String) {
        val updatedItems = _cartItems.value.orEmpty().filter { it.productName != productName }
        _cartItems.value = updatedItems
    }
}
