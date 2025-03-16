package com.example.finalproject001.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }

    fun fetchProductById(productId: String) {
        viewModelScope.launch {
            _selectedProduct.value = repository.getProductById(productId)
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            repository.addProduct(product)
            fetchProducts() // Refresh product list
        }
    }

    fun updateProduct(productId: String, updatedProduct: Product) {
        viewModelScope.launch {
            repository.updateProduct(productId, updatedProduct)
            fetchProducts() // Refresh product list
        }
    }

    fun deleteProduct(productId: String) {
        viewModelScope.launch {
            repository.deleteProduct(productId)
            fetchProducts() // Refresh product list
        }
    }
}
