package com.example.finalproject001

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject001.screen.CheckOutScreen
import com.example.finalproject001.screen.GetStartedScreen
import com.example.finalproject001.screen.GreetingScreen
import com.example.finalproject001.screen.LoginScreen
import com.example.finalproject001.screen.MainMenuScreen
import com.example.finalproject001.screen.RegistrationScreen
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject001.screen.ItemScreen
import com.example.finalproject001.screen.mainmenu.CartPage
import com.example.finalproject001.viewmodel.CartViewModel
import com.example.finalproject001.data.CartItem
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.finalproject001.data.Product
import com.example.finalproject001.data.ProductRepository
import com.example.finalproject001.data.ProductViewModel
import com.example.finalproject001.screen.FilePickerScreen
import com.example.finalproject001.screen.ForgotPasswordScreen
import com.example.finalproject001.screen.UpdateAccountScreen
import com.example.finalproject001.screen.UpdatePasswordScreen
import com.example.finalproject001.screen.admin.AddProductScreen
import com.example.finalproject001.screen.admin.AdminOptionsScreen
import com.example.finalproject001.screen.admin.AdminPage
import com.example.finalproject001.screen.admin.EditProductScreen
import com.example.finalproject001.screen.admin.ProductsManagementScreen
import com.example.finalproject001.screen.admin.TransactionDetailsScreen
import com.example.finalproject001.screen.admin.TransactionsScreen
import com.example.finalproject001.screen.admin.UsersManagementScreen
import com.example.finalproject001.screen.mainmenu.AboutUsScreen
import com.example.finalproject001.viewmodel.AdminViewModel
import com.example.finalproject001.viewmodel.TransactionViewModel
import com.google.firebase.auth.ktx.auth

@Composable
fun AppNavigation(modifier: Modifier = Modifier,
                  cartViewModel: CartViewModel,
                  productViewModel: ProductViewModel,
                  adminViewModel: AdminViewModel,
                  transactionViewModel: TransactionViewModel) {
    val navController = rememberNavController()
    val isLoggedIn = Firebase.auth.currentUser != null
    val firstPage = if (isLoggedIn) Routes.mainmenuScreen else Routes.greetingScreen

    NavHost(navController = navController, startDestination = firstPage) {
        composable(Routes.greetingScreen) {
            GreetingScreen(modifier, navController)
        }
        composable(Routes.getstartedScreen) {
            GetStartedScreen(modifier, navController)
        }
        composable(Routes.registrationScreen) {
            RegistrationScreen(modifier, navController)
        }
        composable(Routes.loginScreen) {
            LoginScreen(modifier, navController)
        }
        composable(Routes.mainmenuScreen) {
            MainMenuScreen(modifier, navController, cartViewModel)
        }
        composable(Routes.updateAccountScreen) {
            UpdateAccountScreen(modifier, navController)
        }
        composable(Routes.updatePasswordScreen) {
            UpdatePasswordScreen(navController)
        }
        composable(Routes.forgotPasswordScreen) {
            ForgotPasswordScreen(navController)
        }
        composable(Routes.checkoutScreen) {
            CheckOutScreen(modifier, navController, cartViewModel)
        }
        composable(Routes.cartPage) {
            CartPage(navController, cartViewModel)
        }
        composable(Routes.filePickerScreen) {
            FilePickerScreen(modifier, navController)
        }
        composable("${Routes.itemScreen}/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")

            // Prevent further execution if productId is null
            if (productId.isNullOrEmpty()) return@composable

            // Fetch product details from Firestore when productId changes
            LaunchedEffect(productId) {
                productViewModel.fetchProductById(productId)
            }

            // Observe the selected product state
            val productState by remember { productViewModel.selectedProduct }.collectAsState(initial = null)

            // Show loading or error message if needed
            if (productState == null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else {
                ItemScreen(navController, productState, cartViewModel)
            }
        }
        composable(Routes.aboutUsPage) {
            AboutUsScreen(navController)
        }
        composable(Routes.adminPage){
            AdminPage(navController, adminViewModel, productViewModel, transactionViewModel)
        }
        composable(Routes.userManagementScreen){
            UsersManagementScreen()
        }
        composable(Routes.transactionScreen){
            TransactionsScreen(navController, transactionViewModel)
        }
        composable(Routes.productManagementScreen){
            ProductsManagementScreen(navController, productViewModel)
        }
        composable(Routes.adminOptionsScreen){
            AdminOptionsScreen(navController)
        }
        composable(Routes.addProductScreen){
            AddProductScreen(navController, productViewModel)
        }
        composable("edit_product/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            val product = productViewModel.getProductById(productId)

            if (product != null) { // ✅ Ensure product is not null
                EditProductScreen(
                    navController = navController,
                    productViewModel = productViewModel,
                    product = product, // ✅ Ensure this is a Product object
                    onResult = { success ->
                        if (success) {
                            navController.popBackStack() // ✅ Navigate back on success
                        } else {
                            println("Product update failed") // ✅ Handle failure
                        }
                    }
                )
            } else {
                println("Product not found") // ✅ Debugging output
            }
        }
        composable("transaction_details/{transactionId}") { backStackEntry ->
            val transactionId = backStackEntry.arguments?.getString("transactionId") ?: ""
            TransactionDetailsScreen(navController, transactionId, transactionViewModel)
        }
    }
}

