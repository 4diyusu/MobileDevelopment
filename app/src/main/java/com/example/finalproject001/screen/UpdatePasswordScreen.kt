package com.example.finalproject001.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject001.viewmodel.AuthViewModel

@Composable
fun UpdatePasswordScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()) {
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) } // Toggle visibility
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Change Password", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField("Current Password", currentPassword, { currentPassword = it }, passwordVisible)
        Spacer(modifier = Modifier.height(8.dp))

        PasswordTextField("New Password", newPassword, { newPassword = it }, passwordVisible)
        Spacer(modifier = Modifier.height(8.dp))

        PasswordTextField("Confirm New Password", confirmNewPassword, { confirmNewPassword = it }, passwordVisible)
        Spacer(modifier = Modifier.height(8.dp))

        // Show password toggle button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        ) {
            Checkbox(checked = passwordVisible, onCheckedChange = { passwordVisible = it })
            Text(text = "Show Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(onClick = { navController.popBackStack() }) {
                Text("Cancel")
            }

            Button(onClick = {
                if (newPassword != confirmNewPassword) {
                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                isLoading = true
                authViewModel.changePassword(currentPassword, newPassword) { success, errorMessage ->
                    isLoading = false
                    if (success) {
                        Toast.makeText(context, "Password changed successfully!", Toast.LENGTH_SHORT).show()
                        navController.popBackStack() // Navigate back
                    } else {
                        Toast.makeText(context, errorMessage ?: "Password change failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }) {
                Text("Update Password")
            }
        }
    }
}

@Composable
fun PasswordTextField(label: String, value: String, onValueChange: (String) -> Unit, passwordVisible: Boolean) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { onValueChange(value) }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}
