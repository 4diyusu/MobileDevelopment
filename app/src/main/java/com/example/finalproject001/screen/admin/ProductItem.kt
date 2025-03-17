package com.example.finalproject001.screen.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject001.data.Product

@Composable
fun ProductItem(
    product: Product,
    onEditClick: (Product) -> Unit,
    onDeleteClick: (Product) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween // Aligns icons to the right
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = product.name, fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            Text(text = "Php ${product.price}", fontSize = 16.sp, color = Color.Gray)
        }

        // Icons aligned to the right
        Row {
            IconButton(onClick = { onEditClick(product) }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
            }
            IconButton(onClick = { onDeleteClick(product) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete", tint = Color.Red)
            }
        }
    }
}
