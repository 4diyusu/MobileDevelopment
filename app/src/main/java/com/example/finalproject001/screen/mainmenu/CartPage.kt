package com.example.finalproject001.screen.mainmenu

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.finalproject001.Routes

@Composable
fun CartPage(navController: NavController, cartViewModel: CartViewModel) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Your Cart", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        if (cartItems.isEmpty()) {
            Text(text = "Your cart is empty!", fontSize = 18.sp, color = Color.Gray)
        } else {
            LazyColumn {
                items(cartItems) { cartItem ->
                    CartItemRow(cartItem, cartViewModel)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val totalPrice = cartItems.sumOf { it.price * it.quantity }
        Text(text = "Total: Php $totalPrice", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate(Routes.checkoutScreen) },
            enabled = cartItems.isNotEmpty()
        ) {
            Text(text = "Proceed to Checkout")
        }
    }
}

@Composable
fun CartItemRow(cartItem: CartItem, cartViewModel: CartViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()) // Scrolls the entire row
            .clip(RoundedCornerShape(16.dp)) // Rounded corners
            .padding(16.dp)
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = cartItem.name, fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "Php ${cartItem.price}", fontSize = 16.sp, color = Color.DarkGray)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Adds spacing between items
        ) {
            Button(
                onClick = {
                    if (cartItem.quantity > 1) {
                        cartViewModel.updateQuantity(cartItem, cartItem.quantity - 1)
                    } else {
                        cartViewModel.removeFromCart(cartItem)
                    }
                },
                modifier = Modifier.size(54.dp)
            ) {
                Text(text = "-", color = Color.White)
            }

            Text(
                text = cartItem.quantity.toString(),
                fontSize = 18.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Button(
                onClick = { cartViewModel.updateQuantity(cartItem, cartItem.quantity + 1) },
                modifier = Modifier.size(54.dp)
            ) {
                Text(text = "+", color = Color.White)
            }
        }
    }
}
