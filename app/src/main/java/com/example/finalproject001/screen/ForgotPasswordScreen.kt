package com.example.finalproject001.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject001.viewmodel.AuthViewModel

@Composable
fun ForgotPasswordScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Forgot Password", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            isLoading = true
            authViewModel.forgotPassword(email, username) { success, message ->
                isLoading = false
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                if (success) {
                    navController.popBackStack()
                }
            }
        }) {
            Text(text = if (isLoading) "Processing..." else "Reset Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Back to Login",
            color = Color.Blue,
            modifier = Modifier.clickable { navController.popBackStack() }
        )
    }
}
