package com.example.finalproject001.screen.mainmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
    val cartItems by remember { mutableStateOf(cartViewModel.cartItems) }
    val totalPrice = cartItems.sumOf { it.product.price * it.quantity }

    Column(
        modifier = Modifier
            .fillMaxWidth()
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
            items(cartViewModel.cartItems) { cartItem ->
                CartItemRow(cartItem = cartItem, cartViewModel = cartViewModel)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total: PHP $totalPrice",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Button(
            onClick = { navController.navigate(Routes.checkoutScreen) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Proceed to Checkout", fontSize = 18.sp)
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
        Text(text = cartItem.product.title, color = Color.White)
        Text(text = "Qty: ${cartItem.quantity}", color = Color.White)
        Text(text = "PHP ${cartItem.product.price * cartItem.quantity}", color = Color.White)

        Row {
            IconButton(onClick = { cartViewModel.updateQuantity(cartItem.product.id, cartItem.quantity - 1) }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "Decrease Quantity")
            }

            IconButton(onClick = { cartViewModel.updateQuantity(cartItem.product.id, cartItem.quantity + 1) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Increase Quantity")
            }
        }
    }
}
