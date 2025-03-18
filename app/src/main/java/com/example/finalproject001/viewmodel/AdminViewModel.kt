package com.example.finalproject001.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AdminViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    init {
        fetchProducts()
        fetchUsers()
    }

    // 🔹 Fetch Products from Firestore and Listen for Changes
    fun fetchProducts() {
        db.collection("products").addSnapshotListener { snapshot, _ ->
            val productList = snapshot?.documents?.mapNotNull { doc ->
                Product(
                    id = doc.id, // Ensure ID is assigned
                    name = doc.getString("name") ?: "",
                    price = doc.getDouble("price") ?: 0.0,
                    details = doc.getString("details") ?: "",
                    imgUrl = doc.getString("imgUrl") ?: ""
                )
            } ?: emptyList()

            _products.value = productList
        }
    }

    // 🔹 Add a New Product
    fun addProduct(product: Product) {
        val newProductRef = db.collection("products").document()
        val newProduct = product.copy(id = newProductRef.id) // Assign Firestore ID

        viewModelScope.launch {
            try {
                newProductRef.set(newProduct).await()
                fetchProducts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // 🔹 Update an Existing Product
    fun updateProduct(productId: String, updatedProduct: Product) {
        viewModelScope.launch {
            try {
                val productMap = mapOf(
                    "name" to updatedProduct.name,
                    "price" to updatedProduct.price,
                    "details" to updatedProduct.details,
                    "imgUrl" to updatedProduct.imgUrl
                )

                db.collection("products").document(productId).update(productMap).await()
                fetchProducts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // 🔹 Delete a Product
    fun deleteProduct(productId: String) {
        viewModelScope.launch {
            try {
                db.collection("products").document(productId).delete().await()
                fetchProducts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // 🔹 Fetch Users from Firestore
    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val snapshot = db.collection("users").get().await()

                val userList = snapshot.documents.mapNotNull { doc ->
                    User(
                        id = doc.id,
                        firstName = doc.getString("firstName") ?: "",
                        lastName = doc.getString("lastName") ?: "",
                        email = doc.getString("email") ?: "",
                        username = doc.getString("username") ?: ""
                    )
                }
                _users.value = userList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // 🔹 Delete a User
    fun deleteUser(userId: String) {
        viewModelScope.launch {
            try {
                db.collection("users").document(userId).delete().await()
                fetchUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // 🔹 Update User Details
    fun updateUser(userId: String, updatedUser: User) {
        viewModelScope.launch {
            try {
                val userMap = mapOf(
                    "firstName" to updatedUser.firstName,
                    "lastName" to updatedUser.lastName,
                    "email" to updatedUser.email,
                    "username" to updatedUser.username
                )

                db.collection("users").document(userId).update(userMap).await()
                fetchUsers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
