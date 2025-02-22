package com.example.finalproject001.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.R
import com.example.finalproject001.Routes

@Composable
fun GetStartedScreen(modifier: Modifier = Modifier, navController: NavController){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(60.dp))

        Image(painter = painterResource(id = R.drawable.bookstore_logo2), contentDescription = "BookStore Logo",
            modifier = Modifier.size(200.dp),
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(text = "Welcome!", fontSize = 28.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(Routes.loginScreen)
        }, Modifier.width(140.dp)){
            Text(text = "Login", fontStyle = FontStyle.Italic)
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedButton(onClick = {
                navController.navigate(Routes.registrationScreen)
        }, Modifier.width(140.dp)) {
                Text(text = "Register", fontStyle = FontStyle.Italic)
        }

        Spacer(modifier = Modifier.height(80.dp))

        Image(painter = painterResource(id = R.drawable.mcm_logowname), contentDescription = "BookStore Logo",
            modifier = Modifier.size(200.dp),
        )
    }
}