package com.example.finalproject001

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject001.screen.CheckOutScreen
import com.example.finalproject001.screen.GetStartedScreen
import com.example.finalproject001.screen.GreetingScreen
import com.example.finalproject001.screen.ItemScreen
import com.example.finalproject001.screen.LoginScreen
import com.example.finalproject001.screen.MainMenuScreen
import com.example.finalproject001.screen.RegistrationScreen
import com.example.finalproject001.screen.mainmenu.HomePage
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun ItemNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ItemScreen", builder ={
        composable(Routes.itemScreen){
            ItemScreen(modifier, navController)
        }
    })
}