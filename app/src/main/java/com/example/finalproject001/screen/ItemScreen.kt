package com.example.finalproject001.screen

import android.content.Context
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.remember
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

@Composable
fun ItemScreen(modifier: Modifier,
               navController: NavController,
               id: Int,
               title: String,
               price: Double,
               description: String,
               productImageId: Int = 0)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = productImageId),
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Price: Php $price", fontSize = 18.sp, color = Color.Gray)
        Text(text = description, fontSize = 16.sp, modifier = Modifier.padding(top = 8.dp))

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back to Products")
        }
    }
}

