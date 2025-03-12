package com.example.finalproject001.screen

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.data.DataProvider
import com.example.finalproject001.data.ProductData
import com.example.finalproject001.viewmodel.CartViewModel

@Composable
fun ItemScreen(
    navController: NavController? = null,
    productId: String,
    cartViewModel: CartViewModel
) {
    val context = LocalContext.current
    val product = DataProvider.productList.find { it.id.toString() == productId }
    var quantity by remember { mutableStateOf(1) } // ✅ Fix state initialization

    if (product != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2D3536))
                .verticalScroll(rememberScrollState())
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

            Text(text = product.title, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "Price: Php ${product.price}", fontSize = 18.sp, color = Color.Gray)
            Text(text = product.description, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp), color = Color.LightGray)

            // Quantity Selection
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
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.LightGray
                )
                Button(onClick = { quantity++ }) {
                    Text(text = "+")
                }
            }

            // ✅ Updated Add to Cart Button
            Button(
                onClick = {
                    Log.d("ItemScreen", "Clicked Add to Cart: ${product.title} - Qty: $quantity")

                    // ✅ Convert ProductData to CartItem
                    val cartItem = CartItem(
                        id = product.id.toString(),
                        name = product.title,
                        price = product.price,
                        quantity = quantity,
                        imageRes = product.productImageId
                    )

                    cartViewModel.addToCart(cartItem)

                    Toast.makeText(context, "Item added to Cart", Toast.LENGTH_SHORT).show()

                    navController?.popBackStack() // ✅ Navigate back safely
                }
            ) {
                Text(text = "Add to Cart")
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController?.popBackStack() },
                enabled = navController != null
            ) {
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
