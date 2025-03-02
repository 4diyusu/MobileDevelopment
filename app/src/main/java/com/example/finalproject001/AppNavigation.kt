package com.example.finalproject001

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.finalproject001.data.ProductData
import com.example.finalproject001.screen.ItemScreen
import com.example.finalproject001.screen.mainmenu.HomePage
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
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
            MainMenuScreen(modifier, navController)
        }
        composable(Routes.checkoutScreen) {
            CheckOutScreen(modifier, navController)
        }
        composable("${Routes.itemScreen}/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: "0"
            ItemScreen(navController = navController, productId = productId)
        }
    }
}
