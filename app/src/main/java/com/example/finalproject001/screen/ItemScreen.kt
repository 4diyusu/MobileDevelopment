package com.example.finalproject001.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.finalproject001.data.CartItem
import com.example.finalproject001.data.Product
import com.example.finalproject001.viewmodel.CartViewModel

@Composable
fun ItemScreen(navController: NavController, product: Product?, cartViewModel: CartViewModel) {
    val context = LocalContext.current

    if (product == null) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF2D3536)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Product not found!", color = Color.White, fontSize = 20.sp)
        }
        return
    }

    var quantity by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D3536))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AsyncImage(
            model = product.imgUrl,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = product.name, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.Bold)
        Text(text = "Price: Php ${product.price}", fontSize = 20.sp, color = Color.Yellow)
        Text(text = product.details, fontSize = 16.sp, color = Color.Gray, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(16.dp))

        // Quantity Selector using Regular Buttons
        Row(
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
                color = Color.White,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Button(
                onClick = { quantity++ }
            ) {
                Text(text = "+")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { cartViewModel.addToCart(product, quantity)
            Toast.makeText(context, "Item Added to cart successfully", Toast.LENGTH_SHORT).show()}) {
            Text(text = "Add to Cart")
        }
    }
}
