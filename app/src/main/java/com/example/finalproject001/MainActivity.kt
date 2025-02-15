package com.example.finalproject001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalproject001.screen.CheckOutScreen
import com.example.finalproject001.screen.GetStartedScreen
import com.example.finalproject001.screen.GreetingScreen
import com.example.finalproject001.screen.LoginScreen
import com.example.finalproject001.screen.MainMenuScreen
import com.example.finalproject001.screen.RegistrationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            Box(Modifier.safeDrawingPadding())
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.greetingScreen, builder ={
                composable(Routes.greetingScreen){
                    GreetingScreen(navController)
                }
                composable(Routes.getstartedScreen){
                    GetStartedScreen(navController)
                }
                composable(Routes.registrationScreen){
                    RegistrationScreen(navController)
                }
                composable(Routes.loginScreen){
                    LoginScreen(navController)
                }
                composable(Routes.mainmenuScreen){
                    MainMenuScreen(navController)
                }
                composable(Routes.checkoutScreen){
                    CheckOutScreen(navController)
                }
            })
        }
    }
}
