package com.example.finalproject001.screen.admin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.viewmodel.TransactionViewModel
import com.example.finalproject001.data.Transaction
import com.example.finalproject001.utils.formatTimestamp

@Composable
fun TransactionsScreen(navController: NavController, transactionViewModel: TransactionViewModel) {
    val transactions by transactionViewModel.transactions.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Transaction History", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        LazyColumn {
            items(transactions) { transaction ->
                TransactionItem(transaction) {
                    navController.navigate("transaction_details/${transaction.transactionId}")
                }
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Transaction ID: ${transaction.transactionId}", fontWeight = FontWeight.Bold)
            Text(text = "Total Amount: Php ${transaction.totalPrice}")
            Text(text = "Date: ${formatTimestamp(transaction.timestamp)}")
        }
    }
}
