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

    suspend fun getProductById(productId: String): Product? {
        return try {
            val doc = productCollection.document(productId).get().await()
            doc.toObject(Product::class.java)?.copy(id = doc.id)
        } catch (e: Exception) {
            null // Return null if not found
        }
    }

    fun getProductById(productId: String, onResult: (Product?) -> Unit) {
        productCollection.document(productId).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val product = document.toObject(Product::class.java)?.copy(id = document.id)
                    onResult(product)
                } else {
                    onResult(null)
                }
            }
            .addOnFailureListener {
                onResult(null)
            }
    }

    fun addProduct(product: Product, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val newProductRef = productCollection.document() // Generate unique ID
        val productWithId = product.copy(id = newProductRef.id)

        newProductRef.set(productWithId)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

    fun updateProduct(product: Product, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        productCollection.document(product.id)
            .set(product) // ✅ Replaces existing data
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

    suspend fun deleteProduct(productId: String) {
        productCollection.document(productId).delete().await()
    }
}

