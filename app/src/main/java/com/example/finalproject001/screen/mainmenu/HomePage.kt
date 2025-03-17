package com.example.finalproject001.screen.mainmenu

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.finalproject001.Routes
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.ProductViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier, productViewModel: ProductViewModel, navController: NavController) {
    val productList by productViewModel.products.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    // Filter products based on search
    val filteredProducts = productList.filter { it.name.contains(searchQuery, ignoreCase = true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Products",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        SearchBar(searchQuery) { searchQuery = it }

        Spacer(modifier = Modifier.height(8.dp))

        if (filteredProducts.isEmpty()) {
            Text(text = "No products found.", style = MaterialTheme.typography.bodyLarge)
        } else {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 72.dp)
            ) {
                items(filteredProducts) { product ->
                    ProductCard(product, navController)
                }
            }
        }
    }
}

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        label = { Text("Search products...") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { /* Handle search */ })
    )
}


@Composable
fun ProductCard(product: Product, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Log.d("ProductCard", "Navigating to ItemScreen with ID: ${product.id}") // Debug log
                navController.navigate("${Routes.itemScreen}/${product.id}")
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF949494))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = product.imgUrl,
                contentDescription = "Product Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = product.name, fontSize = 18.sp, color = Color.White)
                Text(text = "Php ${product.price}", fontSize = 14.sp, color = Color.Yellow)
                Text(text = "VIEW DETAILS", fontSize = 14.sp, color = Color.DarkGray)
            }
        }
    }
}
