package com.example.finalproject001.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.R
import com.example.finalproject001.Routes
import com.example.finalproject001.viewmodel.CartViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.util.UUID
import java.util.Date


@Composable
fun CheckOutScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    cartViewModel: CartViewModel // Pass the cartViewModel to get cart items
) {
    val context = LocalContext.current
    val db = FirebaseFirestore.getInstance()
    val cartItems = cartViewModel.cartItems.value ?: emptyList()
    val totalPrice = cartItems.sumOf { it.price * it.quantity }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Text(
            text = "CHECKOUT SCREEN",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display Cart Items
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            cartItems.forEach { item ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item.name, fontSize = 18.sp)
                    Text(text = "Php ${"%.2f".format(item.price * item.quantity)}", fontSize = 18.sp)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Total Price
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Total:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Php ${"%.2f".format(totalPrice)}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Confirm Purchase Button
        Button(onClick = {
            if (cartItems.isNotEmpty()) {
                val transactionId = UUID.randomUUID().toString() // Generate unique ID
                val transactionData = hashMapOf(
                    "transactionId" to transactionId,
                    "items" to cartItems.map { item ->
                        hashMapOf(
                            "id" to item.id,
                            "name" to item.name,
                            "quantity" to item.quantity,
                            "price" to item.price
                        )
                    },
                    "totalPrice" to totalPrice,
                    "timestamp" to Date(),
                )

                db.collection("transactions").document(transactionId)
                    .set(transactionData)
                    .addOnSuccessListener {
                        Toast.makeText(context, "Transaction Saved!", Toast.LENGTH_SHORT).show()
                        Toast.makeText(context, "Thank you for your purchase!", Toast.LENGTH_LONG).show()
                        cartViewModel.clearCart() // Clear cart after checkout
                        navController.navigate(Routes.mainmenuScreen)
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(context, "Failed: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(context, "Cart is empty!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Confirm Purchase")
        }
    }
}
