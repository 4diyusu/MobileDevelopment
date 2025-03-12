package com.example.finalproject001.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject001.AppUtil
import com.example.finalproject001.Routes
import com.example.finalproject001.model.UserModel
import com.example.finalproject001.viewmodel.AuthViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

@Composable
fun UpdateAccountScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {
    val currentUser = Firebase.auth.currentUser
    val context = LocalContext.current

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    // 🔥 Load user data from Firestore
    LaunchedEffect(currentUser) {
        currentUser?.uid?.let { userId ->
            Firebase.firestore.collection("users").document(userId).get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        firstName = document.getString("firstName") ?: ""
                        lastName = document.getString("lastName") ?: ""
                        email = document.getString("email") ?: ""
                        phone = document.getString("phone") ?: ""
                        username = document.getString("username") ?: ""
                    }
                }
                .addOnFailureListener {
                    Toast.makeText(context, "Failed to load user data", Toast.LENGTH_SHORT).show()
                }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Update Account", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = firstName, onValueChange = { firstName = it }, label = { Text(text = "First Name") })
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = lastName, onValueChange = { lastName = it }, label = { Text(text = "Last Name") })
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text(text = "E-Mail") }, enabled = false)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = phone, onValueChange = { phone = it }, label = { Text(text = "Phone Number") })
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = username, onValueChange = { username = it }, label = { Text(text = "Username") })
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(onClick = { navController.navigate(Routes.mainmenuScreen) }) {
                Text(text = "Back")
            }

            Button(onClick = {
                isLoading = true

                authViewModel.updateAccount(
                    firstName = firstName,
                    lastName = lastName,
                    phone = phone,
                    username = username
                ) { success, errorMessage ->
                    isLoading = false
                    if (success) {
                        Toast.makeText(context, "Account Updated Successfully!", Toast.LENGTH_SHORT).show()
                        navController.navigate(Routes.mainmenuScreen) {
                            popUpTo(Routes.updateAccountScreen) { inclusive = true }
                        }
                    } else {
                        Toast.makeText(context, errorMessage ?: "Update failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }) {
                Text(text = "Update Account")
            }
        }
    }
}
