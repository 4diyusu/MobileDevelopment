package com.example.finalproject001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalproject001.data.ProductRepository
import com.example.finalproject001.data.ProductViewModel
import com.example.finalproject001.screen.ItemScreen
import com.example.finalproject001.viewmodel.CartViewModel
import kotlinx.coroutines.flow.SharingStarted

class ItemActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val productId = intent.getStringExtra("productId") ?: return // Get product ID from intent

        setContent {
            val navController = rememberNavController() // Create a NavController
            val cartViewModel: CartViewModel = viewModel() // Retrieve CartViewModel

            // ✅ FIX: Initialize ProductViewModel correctly
            val productViewModel: ProductViewModel = viewModel(
                factory = ProductViewModelFactory(ProductRepository())
            )

            // ✅ FIX: Collect state properly without delegation (`by` is removed)
            val productState = productViewModel.selectedProduct.collectAsState(initial = null)

            // ✅ Pass the required parameters to ItemScreen
            ItemScreen(navController, productState.value, cartViewModel)
        }
    }
}

