package com.example.finalproject001.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdminViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        db.collection("products").addSnapshotListener { snapshot, _ ->
            val productList = snapshot?.documents?.mapNotNull { it.toObject(Product::class.java) } ?: emptyList()
            _products.value = productList
        }
    }

    fun addNewProduct() {
        val newProduct = Product(
            id = db.collection("products").document().id,
            name = "New Product",
            price = 0.0,
            details = "Product Description",
            imgUrl = ""
        )

        db.collection("products").document(newProduct.id).set(newProduct)
    }

    fun editProduct(product: Product) {
        db.collection("products").document(product.id).set(product)
    }

    fun deleteProduct(product: Product) {
        db.collection("products").document(product.id).delete()
    }
}
