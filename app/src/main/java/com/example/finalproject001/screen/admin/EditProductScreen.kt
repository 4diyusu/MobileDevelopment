package com.example.finalproject001.screen.admin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.ProductViewModel

@Composable
fun EditProductScreen(
    navController: NavController,
    productViewModel: ProductViewModel,
    product: Product,
    onResult: (Boolean) -> Unit
) {
    val context = LocalContext.current

    var name by remember { mutableStateOf(product.name) }
    var price by remember { mutableStateOf(product.price.toString()) }
    var details by remember{ mutableStateOf(product.details)}
    var imageUrl by remember { mutableStateOf(product.imgUrl) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Edit Product", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Product Name")
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Price")
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Product Details")
        OutlinedTextField(
            value = details,
            onValueChange = { details = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Image URL")
        OutlinedTextField(
            value = imageUrl,
            onValueChange = { imageUrl = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                productViewModel.updateProduct(
                    product.copy(name = name, price = price.toDouble(), details = details, imgUrl = imageUrl),
                    onSuccess = {
                        Toast.makeText(context, "Product Update successful", Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    },
                    onFailure = { errorMessage ->
                        println("Error updating product: $errorMessage")
                    }
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update Product")
        }

    }
}
