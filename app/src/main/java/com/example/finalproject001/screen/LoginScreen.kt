package com.example.finalproject001.screen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import com.example.finalproject001.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject001.AppUtil
import com.example.finalproject001.Routes
import com.example.finalproject001.viewmodel.AuthViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) } // Toggle password visibility
    var isLoading by remember { mutableStateOf(false) }

    BackHandler {
        // Do nothing, effectively disabling back button
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bookstore_logowname2),
            contentDescription = "BookStore Logo",
            modifier = Modifier.size(300.dp)
        )

        Text(text = "Welcome!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Login to your Account")
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Password Field with Show/Hide Toggle
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick = {
            isLoading = true

            if (username.isBlank() || password.isBlank()) {
                isLoading = false
                Toast.makeText(context, "Please enter Email and Password", Toast.LENGTH_SHORT).show()
                return@Button
            }
            if (username == "admin" && password == "admin"){
                isLoading = false
                Toast.makeText(context, "Successful ADMIN Login!", Toast.LENGTH_SHORT).show()
                navController.navigate(Routes.adminPage) {
                    popUpTo(Routes.getstartedScreen) { inclusive = true }
                }
            }else{
                authViewModel.login(username, password) { success, errorMessage ->
                    isLoading = false
                    if (success) {
                        Toast.makeText(context, "Successful Login!", Toast.LENGTH_SHORT).show()
                        navController.navigate(Routes.mainmenuScreen) {
                            popUpTo(Routes.getstartedScreen) { inclusive = true }
                        }
                    } else {
                        AppUtil.showToast(context, errorMessage ?: "Something went wrong")
                    }
                }
            }
        }) {
            Text(text = if (isLoading) "Logging in" else "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Forgot Password?", color = Color.Magenta, modifier = Modifier.clickable {
                navController.navigate(Routes.forgotPasswordScreen)
            })
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "or")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Signup",
                color = Color.Blue,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.registrationScreen) {
                        popUpTo(Routes.loginScreen) { inclusive = true }
                    }
                }
            )
        }
    }
}
