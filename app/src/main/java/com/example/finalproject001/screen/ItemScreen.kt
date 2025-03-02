package com.example.finalproject001.screen

import android.content.Context
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.MainActivity
import com.example.finalproject001.ProductListItem
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
    var quantity by remember { mutableStateOf(1) } // Tracks quantity selection

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
                Button(onClick = { if (quantity > 1) quantity-- }) {
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
                    cartViewModel.addToCart(product, quantity) // Add item to cart
                    navController.popBackStack() // Go back after adding
                },
                modifier = Modifier.fillMaxWidth()
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