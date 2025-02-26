package com.example.finalproject001

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.finalproject001.data.ProductData

@Composable
fun ProductListItem(productData: ProductData){
    Row{
        Column{
            Text(text = productData.title, style = typography.labelSmall)
            Text(text = "VIEW DETAIL", style = typography.bodyMedium)
        }
    }

}