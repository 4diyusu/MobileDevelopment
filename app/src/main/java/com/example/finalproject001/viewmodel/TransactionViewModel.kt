package com.example.finalproject001.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject001.data.Transaction
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {
    private val firestore = FirebaseFirestore.getInstance()
    private val _transactions = MutableStateFlow<List<Transaction>>(emptyList())
    val transactions: StateFlow<List<Transaction>> = _transactions

    init {
        fetchTransactions()
    }

    private fun fetchTransactions() {
        firestore.collection("transactions")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                val transactionList = value?.documents?.mapNotNull { doc ->
                    doc.toObject(Transaction::class.java)
                } ?: emptyList()
                _transactions.value = transactionList
            }
    }

    fun getTransactionById(transactionId: String): Transaction? {
        return _transactions.value.find { it.transactionId == transactionId }
    }
}
