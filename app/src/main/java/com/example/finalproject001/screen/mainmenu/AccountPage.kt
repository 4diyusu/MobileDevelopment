package com.example.finalproject001.screen.mainmenu

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.Routes
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun AccountPage(navController: NavController, modifier: androidx.compose.ui.Modifier = Modifier){

    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize()
            .background(Color(0xFF2D3536)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Account Page",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = Modifier.size(width = 180.dp, height = 40.dp),
            onClick = {
            navController.navigate(Routes.updateAccountScreen)
        }){
            Text(text = "Update Account Details")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(modifier = Modifier.size(width = 180.dp, height = 40.dp),
            onClick = {
            navController.navigate(Routes.updatePasswordScreen)
        }){
            Text(text = "Change Passsword")
        }

        Spacer(modifier = Modifier.height(390.dp))

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