package com.example.finalproject001.screen.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.viewmodel.TransactionViewModel
import com.example.finalproject001.utils.formatTimestamp

@Composable
fun TransactionDetailsScreen(navController: NavController, transactionId: String, transactionViewModel: TransactionViewModel) {
    val transaction = transactionViewModel.getTransactionById(transactionId)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Transaction Details", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        transaction?.let {
            Text(text = "Transaction ID: ${it.transactionId}", fontWeight = FontWeight.Bold)
            Text(text = "Total Amount: Php ${it.totalPrice}")
            Text(text = "Date: ${formatTimestamp(it.timestamp)}")

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Back to Transactions")
            }
        } ?: Text("Transaction not found.")
    }
}
