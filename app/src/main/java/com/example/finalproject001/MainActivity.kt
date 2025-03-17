package com.example.finalproject001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.ProductRepository
import com.example.finalproject001.data.ProductViewModel
import com.example.finalproject001.screen.CheckOutScreen
import com.example.finalproject001.screen.GetStartedScreen
import com.example.finalproject001.screen.GreetingScreen
import com.example.finalproject001.screen.LoginScreen
import com.example.finalproject001.screen.MainMenuScreen
import com.example.finalproject001.screen.RegistrationScreen
import com.example.finalproject001.screen.mainmenu.HomePage
import com.example.finalproject001.viewmodel.AdminViewModel
import com.example.finalproject001.viewmodel.CartViewModel
import com.example.finalproject001.viewmodel.TransactionViewModel

class MainActivity : ComponentActivity() {
    private val cartViewModel: CartViewModel by viewModels()
    private val productViewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(ProductRepository())
    }
    private val adminViewModel: AdminViewModel by viewModels()
    private val transactionViewModel: TransactionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Box(Modifier.safeDrawingPadding()) {
                AppNavigation(
                    modifier = Modifier,
                    cartViewModel = cartViewModel,
                    productViewModel = productViewModel,
                    adminViewModel = adminViewModel,
                    transactionViewModel = transactionViewModel,
                )
            }
        }
    }
}
