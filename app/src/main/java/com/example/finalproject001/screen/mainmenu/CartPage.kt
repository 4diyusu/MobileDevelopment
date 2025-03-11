package com.example.finalproject001.screen.mainmenu

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.viewmodel.CartViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun CartPage(navController: NavController, cartViewModel: CartViewModel) {
    val cartItems by cartViewModel.cartItems.observeAsState(emptyList()) // ✅ Corrected

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D3536))
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Shopping Cart",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(cartItems, key = { it.productName }) { cartItem -> // ✅ Proper recomposition
                CartItemRow(cartItem, cartViewModel)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("checkout") }) {
            Text(text = "Proceed to Checkout")
        }
    }
}

@Composable
fun CartItemRow(cartItem: CartItem, cartViewModel: CartViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${cartItem.productName} - Qty: ${cartItem.quantity}",
            fontSize = 16.sp,
            color = Color.White
        )

        Row {
            Button(onClick = {
                if (cartItem.quantity > 1) {
                    cartViewModel.updateQuantity(cartItem.productName, cartItem.quantity - 1)
                } else {
                    cartViewModel.removeFromCart(cartItem.productName)
                }
            }) {
                Text(text = "-")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { cartViewModel.updateQuantity(cartItem.productName, cartItem.quantity + 1) }) {
                Text(text = "+")
            }
        }
    }
}
