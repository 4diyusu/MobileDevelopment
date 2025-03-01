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
fun AppNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    val isLoggedIn = Firebase.auth.currentUser!=null
    val firstPage = if(isLoggedIn) Routes.mainmenuScreen else Routes.greetingScreen
    NavHost(navController = navController, startDestination = firstPage, builder ={
        composable(Routes.greetingScreen){
            GreetingScreen(modifier, navController)
        }
        composable(Routes.getstartedScreen){
            GetStartedScreen(modifier, navController)
        }
        composable(Routes.registrationScreen){
            RegistrationScreen(modifier, navController)
        }
        composable(Routes.loginScreen){
            LoginScreen(modifier, navController)
        }
        composable(Routes.mainmenuScreen){
            MainMenuScreen(modifier, navController)
        }
        composable(Routes.checkoutScreen){
            CheckOutScreen(modifier, navController)
        }
        composable(
            route = Routes.itemScreen + "/{id}/{title}/{price}/{description}/{productImageId}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("title") { type = NavType.StringType },
                navArgument("price") { type = NavType.FloatType },
                navArgument("description") { type = NavType.StringType },
                navArgument("productImageId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            val title = backStackEntry.arguments?.getString("title") ?: "Unknown"
            val price = backStackEntry.arguments?.getFloat("price")?.toDouble() ?: 0.0
            val description = backStackEntry.arguments?.getString("description") ?: "No Description"
            val productImageId = backStackEntry.arguments?.getInt("productImageId") ?: R.drawable.scientific_calculator_casiofx570ms


            ItemScreen(
                navController = navController,
                id = id,
                title = title,
                price = price,
                description = description,
                productImageId = productImageId,
                modifier = Modifier
            )
        }
    })
}