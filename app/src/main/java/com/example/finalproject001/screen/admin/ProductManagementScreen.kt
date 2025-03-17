package com.example.finalproject001.screen.admin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.Routes
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.ProductViewModel
import com.example.finalproject001.viewmodel.AdminViewModel

@Composable
fun ProductsManagementScreen(
    navController: NavController,
    productViewModel: ProductViewModel
) {
    val products = productViewModel.products.collectAsState(initial = emptyList()).value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Routes.addProductScreen) },
                modifier = Modifier
                    .padding(16.dp)
                    .offset(y = (-56).dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Product")
            }
        }
    ) { paddingValues ->
        Column()
        {
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = " PRODUCTS", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(10.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 56.dp)
                    .padding(paddingValues)
            ) {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        onEditClick = { navController.navigate("edit_product/${product.id}") },
                        onDeleteClick = { productViewModel.deleteProduct(product.id) }
                    )
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color(0xFF74B6CE))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = product.name, fontSize = 18.sp, color = Color.Black)
                Text(text = "Php ${product.price}", fontSize = 16.sp, color = Color.Black)
            }
            Row {
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Product", tint = Color.White)
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete Product", tint = Color.White)
                }
            }
        }
    }
}

