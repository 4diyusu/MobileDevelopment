package com.example.finalproject001

import androidx.compose.runtime.Composable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject001.screen.ItemScreen
import com.example.finalproject001.screen.mainmenu.CartPage
import com.example.finalproject001.viewmodel.CartViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.finalproject001.screen.FilePickerScreen
import com.example.finalproject001.screen.ForgotPasswordScreen
import com.example.finalproject001.screen.UpdateAccountScreen
import com.example.finalproject001.screen.UpdatePasswordScreen
import com.google.firebase.auth.ktx.auth

@Composable
fun AppNavigation(modifier: Modifier = Modifier, cartViewModel: CartViewModel) {
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
            CheckOutScreen(modifier, navController)
        }
        composable(Routes.cartPage) {
            CartPage(navController, cartViewModel)
        }
        composable(Routes.filePickerScreen) {
            FilePickerScreen(modifier, navController)
        }
        composable("${Routes.itemScreen}/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: "0"
            ItemScreen(navController, productId, cartViewModel)
        }
    }
}
