package com.example.finalproject001.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
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
import com.example.finalproject001.viewmodel.AuthViewModel

@Composable
fun RegistrationScreen(navController: NavController, authViewModel: AuthViewModel = viewModel()){

    var firstName by remember{
        mutableStateOf("")
    }
    var lastName by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var phone by remember{
        mutableStateOf("")
    }
    var username by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var cpassword by remember{
        mutableStateOf("")
    }

    var context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Register", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = firstName, onValueChange = {
            firstName = it;
        }, label = {
            Text(text = "First Name")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = lastName, onValueChange = {
            lastName = it;
        }, label = {
            Text(text = "Last Name")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = email, onValueChange = {
            email = it;
        }, label = {
            Text(text = "E-Mail")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = phone, onValueChange = {
            phone = it;
        }, label = {
            Text(text = "Phone Number")
        })

        Spacer(modifier = Modifier.height(36.dp))

        OutlinedTextField(value = username, onValueChange = {
            username = it;
        }, label = {
            Text(text = "Username")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it;
        }, label = {
            Text(text = "Password")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = cpassword, onValueChange = {
            cpassword = it;
        }, label = {
            Text(text = "Repeat Password")
        })

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            Arrangement.SpaceEvenly
        ){
            OutlinedButton(onClick = {
                navController.navigate(Routes.getstartedScreen)
            }) {
                Text(text = "Back")
            }

            val context = LocalContext.current
            Button(onClick = {

                if(password == cpassword){
                    authViewModel.signup(firstName, lastName, email, phone, username, password){success,errorMessage->
                        if(success){
                            Toast.makeText(context,
                                "Successful Registration",
                                Toast.LENGTH_SHORT).show()
                            navController.navigate(Routes.loginScreen)

                        }else{
                            AppUtil.showToast(context,errorMessage?:"Something went wrong")
                        }

                    }
                }else{
                    Toast.makeText(context, "Password does not match", Toast.LENGTH_SHORT).show()
                }
            }){
                Text(text = "Register")
            }
        }
    }
}