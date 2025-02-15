package com.example.finalproject001.screen

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
import com.example.finalproject001.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.Routes

@Composable
fun LoginScreen(navController: NavController){

    val context = LocalContext.current

    var username by remember{
        mutableStateOf("")
    }

    var password by remember{
        mutableStateOf("")
    }

    BackHandler {
        // Do nothing, effectively disabling back button
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.bookstore_logowname2), contentDescription = "BookStore Logo",
            modifier = Modifier.size(300.dp))

        Text(text = "Welcome!", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Login to your Account")

        Spacer(modifier = Modifier.height(8.dp))

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
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick = {
            if(username == "admin" && password == "admin"){
                navController.navigate(Routes.mainmenuScreen){
                    popUpTo(Routes.loginScreen){inclusive = true}
                }
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Wrong Email or Password!", Toast.LENGTH_SHORT).show()
            }
        }){
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Forgot Password?", modifier = Modifier.clickable{

        })
    }
}