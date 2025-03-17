package com.example.finalproject001.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.Transaction
import com.example.finalproject001.data.TransactionProduct
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.tasks.await

class TransactionViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    init {
        fetchTransactions()
    }

    private fun fetchTransactions() {
        viewModelScope.launch {
            try {
                val snapshot = FirebaseFirestore.getInstance()
                    .collection("transactions")
                    .get()
                    .await()

                val transactionList = snapshot.documents.mapNotNull { doc ->
                    val itemsList = doc.get("items") as? List<Map<String, Any>> ?: emptyList()
                    Log.d("FirestoreDebug", "Fetched Items List: $itemsList")

                    val products = itemsList.mapNotNull { item ->
                        val id = item["id"] as? String
                        val name = item["name"] as? String
                        val price = (item["price"] as? Number)?.toDouble()
                        val quantity = (item["quantity"] as? Number)?.toInt()
                        val totalPrice = (item["totalPrice"] as? Number)?.toDouble()

                        Log.d("FirestoreDebug", "Processing Item: id=$id, name=$name, price=$price, quantity=$quantity, totalPrice=$totalPrice")

                        if (id != null && name != null && price != null && quantity != null && totalPrice != null)
                            TransactionProduct(id, name, price, quantity, totalPrice)
                        else
                            null
                    }

                    Log.d("FirestoreDebug", "Processed Products: $products")

                    Transaction(
                        id = doc.id,
                        timestamp = doc.getTimestamp("timestamp"),
                        totalAmount = doc.getDouble("totalPrice") ?: 0.0,  // Ensure it matches Firestore field
                        products = products
                    )
                }

                _transactions.value = transactionList
            } catch (e: Exception) {
                Log.e("FirestoreError", "Error fetching transactions", e)
            }
        }
    }



    suspend fun getTransactionById(transactionId: String): Transaction? {
        return try {
            val doc = db.collection("transactions").document(transactionId).get().await()
            doc.toObject(Transaction::class.java)?.copy(id = doc.id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
