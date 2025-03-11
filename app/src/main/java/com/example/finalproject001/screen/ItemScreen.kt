package com.example.finalproject001.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.data.DataProvider
import com.example.finalproject001.data.ProductData
import com.example.finalproject001.viewmodel.CartViewModel

@Composable
fun ItemScreen(
    navController: NavController,
    productId: String,
    cartViewModel: CartViewModel
) {
    val product = DataProvider.productList.find { it.id.toString() == productId }
    var quantity by remember { mutableIntStateOf(1) }

    if (product != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.productImageId),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = product.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Price: Php ${product.price}", fontSize = 18.sp, color = Color.Gray)
            Text(text = product.description, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

            // Quantity Selector
            Row(
                modifier = Modifier.padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { if (quantity > 1) quantity-- },
                    enabled = quantity > 1
                ) {
                    Text(text = "-")
                }
                Text(
                    text = quantity.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Button(onClick = { quantity++ }) {
                    Text(text = "+")
                }
            }

            // Add to Cart Button
            Button(
                onClick = {
                    Log.d("ItemScreen", "Clicked Add to Cart: ${product.title} - Qty: $quantity")
                    cartViewModel.addToCart(product, quantity)
                    Log.d("ItemScreen", "Cart size after adding: ${cartViewModel.cartItems.value.size}")
                    navController.popBackStack()
                }
            ) {
                Text(text = "Add to Cart")
            }


            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Back to Products")
            }
        }
    } else {
        Text(
            text = "Product not found",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
    }
}




@Composable
fun ItemDetails(product: ProductData) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = product.productImageId),
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Product Name: ${product.title}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Price: PHP ${product.price}", fontSize = 20.sp, color = Color.Gray)
        Text(text = "Description: ${product.description}", fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))
    }
}