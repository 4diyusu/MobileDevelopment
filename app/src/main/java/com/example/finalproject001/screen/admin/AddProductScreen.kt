package com.example.finalproject001.screen.admin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.ProductViewModel

@Composable
fun AddProductScreen(navController: NavController, productViewModel: ProductViewModel) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var imgUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Product Name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = details,
            onValueChange = { details = it },
            label = { Text("Details") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = imgUrl,
            onValueChange = { imgUrl = it },
            label = { Text("Image URL") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val product = Product(
                name = name,
                price = price.toDoubleOrNull() ?: 0.0,
                details = details,
                imgUrl = imgUrl
            )

            productViewModel.addProduct(
                product,
                onSuccess = {
                    Toast.makeText(context, "Product added successfully!", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                },
                onFailure = { exception ->
                    Toast.makeText(context, "Error: ${exception.message}", Toast.LENGTH_SHORT).show()
                }
            )
        }) {
            Text("Add Product")
        }
    }
}
