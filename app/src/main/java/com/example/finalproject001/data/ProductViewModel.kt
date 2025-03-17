package com.example.finalproject001.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun getProductById(productId: String): Product? {
        return _products.value.find { it.id == productId } // ✅ Search in the fetched list
    }

    fun addProduct(product: Product, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch {
            repository.addProduct(product, {
                fetchProducts() // Refresh product list after adding
                onSuccess()
            }, onFailure)
        }
    }

    fun updateProduct(product: Product, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch {
            repository.updateProduct(product, {
                fetchProducts() // Refresh product list after updating
                onSuccess()
            }, onFailure)
        }
    }

    fun deleteProduct(productId: String) {
        viewModelScope.launch {
            repository.deleteProduct(productId)
            fetchProducts() // Refresh product list after deletion
        }
    }
}
