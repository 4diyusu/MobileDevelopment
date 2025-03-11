package com.example.finalproject001.screen.mainmenu

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Divider
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
import com.example.finalproject001.Routes
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.viewmodel.CartViewModel


@Composable
fun CartPage(navController: NavController, cartViewModel: CartViewModel) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    Log.d("CartPage", "Rendering cart with ${cartItems.size} items")

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

        LazyColumn {
            items(cartItems) { cartItem ->
                CartItemRow(cartItem = cartItem, cartViewModel = cartViewModel)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total: PHP ${cartItems.sumOf { it.totalPrice }}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
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
        Column(modifier = Modifier.weight(1f)) {
            Text(text = cartItem.product.title, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "PHP ${cartItem.product.price}", color = Color.Gray)
            Text(text = "Total: PHP ${cartItem.totalPrice}", color = Color.White)
        }

        // Quantity Control
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                if (cartItem.quantity > 1) {
                    cartViewModel.updateQuantity(cartItem.product, cartItem.quantity - 1)
                } else {
                    cartViewModel.removeFromCart(cartItem.product)
                }
            }) {
                Text(text = "-")
            }

            Text(
                text = cartItem.quantity.toString(),
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Color.White
            )

            Button(onClick = { cartViewModel.updateQuantity(cartItem.product, cartItem.quantity + 1) }) {
                Text(text = "+")
            }
        }

        // Remove Button
        Button(
            onClick = { cartViewModel.removeFromCart(cartItem.product) },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text(text = "Remove")
        }
    }
}


