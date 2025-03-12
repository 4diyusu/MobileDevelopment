package com.example.finalproject001.screen.mainmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.R
import com.example.finalproject001.Routes

@Composable
fun ServicesPage(modifier: Modifier = Modifier, navController: NavController){
    Column(
        modifier = modifier.fillMaxSize()
            .background(Color(0xFF2D3536)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "SERVICES PAGE",
            fontSize = 40.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            color = Color.White)

        Spacer(modifier = Modifier.height(10.dp))

        Image(painter = painterResource(id = R.drawable.services_prices), contentDescription = "Services Prices",
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Instructions:", fontWeight = FontWeight.SemiBold, fontSize = 20.sp, color = Color.White)
        Text(text = "\n1. Choose your file" +
                "\n2. Send the file to:" +
                "\n-Gmail: mrmem1003@gmail.com" +
                "\n-Facebook/Messenger: MRMEM" +
                "\n3. Proceed to Bookstore to pay and claim your printed file", fontStyle = FontStyle.Normal, color = Color.White)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(Routes.filePickerScreen)
        }, Modifier.width(140.dp)){
            Text(text = "Find File", fontStyle = FontStyle.Italic)
        }

    }
}