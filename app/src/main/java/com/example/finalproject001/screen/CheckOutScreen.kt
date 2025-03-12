package com.example.finalproject001.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate(Routes.mainmenuScreen) },
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text(text = "Back", fontStyle = FontStyle.Italic)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "CHECKOUT SCREEN", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(80.dp))

        Button(onClick = {
            if (cartItems.isNotEmpty()) {
                val transactionId = UUID.randomUUID().toString() // Generate unique ID
                val transactionData = hashMapOf(
                    "transactionId" to transactionId,
                    "items" to cartItems.map { item ->
                        mapOf(
                            "id" to item.id,
                            "name" to item.name,
                            "quantity" to item.quantity,
                            "price" to item.price
                        )
                    },
                    "totalPrice" to cartItems.sumOf { it.price * it.quantity },
                    "timestamp" to Date()
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
            Text(text = "Purchase", fontStyle = FontStyle.Italic)
        }
    }
}
