package com.example.finalproject001.data

import com.example.finalproject001.data.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ProductRepository {
    private val db = FirebaseFirestore.getInstance()
    private val productCollection = db.collection("products")

    suspend fun getProducts(): List<Product> {
        return try {
            val snapshot = productCollection.get().await()
            snapshot.documents.mapNotNull { it.toObject(Product::class.java)?.copy(id = it.id) }
        } catch (e: Exception) {
            emptyList() // Return empty list if error occurs
        }
    }

    // 🔥 ADD THIS FUNCTION 🔥
    suspend fun getProductById(productId: String): Product? {
        return try {
            val doc = productCollection.document(productId).get().await()
            doc.toObject(Product::class.java)?.copy(id = doc.id)
        } catch (e: Exception) {
            null // Return null if not found
        }
    }

    suspend fun addProduct(product: Product) {
        productCollection.add(product).await()
    }

    suspend fun updateProduct(productId: String, updatedProduct: Product) {
        productCollection.document(productId).set(updatedProduct).await()
    }

    suspend fun deleteProduct(productId: String) {
        productCollection.document(productId).delete().await()
    }
}

