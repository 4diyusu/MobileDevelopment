package com.example.finalproject001.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.R
import com.example.finalproject001.Routes


@Composable
fun GreetingScreen(modifier: Modifier = Modifier, navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Image(painter = painterResource(id = R.drawable.bookstore_logowname2), contentDescription = "BookStore Logo",
            modifier = Modifier.size(300.dp),
        )

        Text(text = "Welcome!", fontSize = 28.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick = {
            navController.navigate(Routes.getstartedScreen) {
                popUpTo(Routes.greetingScreen) { inclusive = true }
            }
        }){
            Text(text = "Get Started", fontStyle = FontStyle.Italic)
        }

        Spacer(modifier = Modifier.height(80.dp))

        Image(painter = painterResource(id = R.drawable.mcm_logowname), contentDescription = "BookStore Logo",
            modifier = Modifier.size(200.dp))

    }
}