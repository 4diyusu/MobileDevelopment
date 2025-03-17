package com.example.finalproject001.screen.admin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalproject001.Routes
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AdminOptionsScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(modifier = Modifier
            .size(width = 180.dp, height = 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            onClick = {
                Firebase.auth.signOut()
                navController.navigate(Routes.loginScreen){
                    popUpTo(Routes.mainmenuScreen){inclusive = true}
                }
                Toast.makeText(context, "Successfully Logged out!", Toast.LENGTH_SHORT).show()
            }){
            Text(text = "Logout")
        }
    }
}
