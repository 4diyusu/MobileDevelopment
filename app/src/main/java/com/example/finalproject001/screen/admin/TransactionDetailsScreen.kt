package com.example.finalproject001.screen.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalproject001.Routes
import com.example.finalproject001.data.Transaction
import com.example.finalproject001.viewmodel.TransactionViewModel

@Composable
fun TransactionDetailsScreen(
    navController: NavController,
    transactionId: String,
    transactionViewModel: TransactionViewModel
) {
    var transaction by remember { mutableStateOf<Transaction?>(null) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(transactionId) {
        transaction = transactionViewModel.getTransactionById(transactionId)
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
            }
            transaction != null -> {
                val trans = transaction!!

                Spacer(modifier = Modifier.height(10.dp))

                Text("Transaction Details", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))

                Text("Transaction ID: ${trans.id}", style = MaterialTheme.typography.bodyLarge)
                Text("Date: ${trans.formattedDate()}", style = MaterialTheme.typography.bodyLarge)
                Text("Total Amount: Php ${String.format("%.2f", trans.totalAmount)}", style = MaterialTheme.typography.bodyLarge)

                Spacer(modifier = Modifier.height(16.dp))
                Text("Products Bought:", style = MaterialTheme.typography.titleMedium)

                LazyColumn {
                    items(trans.products) { product ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            Text(
                                text = "${product.name} - Php ${String.format("%.2f", product.price)}",
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
            else -> {
                Text(
                    "Transaction not found",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(width = 180.dp, height = 40.dp),
            onClick = { navController.navigate(Routes.transactionScreen) }
        ) {
            Text(text = "Return")
        }
    }
}
