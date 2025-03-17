package com.example.finalproject001.screen.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UsersManagementScreen() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color(0xFF74B6CE))
    ) {
        Text(
            text = "Users List (Coming Soon)",
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}
