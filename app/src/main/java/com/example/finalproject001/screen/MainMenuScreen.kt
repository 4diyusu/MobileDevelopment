package com.example.finalproject001.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalproject001.NavItem
import com.example.finalproject001.data.ProductData
import com.example.finalproject001.screen.mainmenu.AccountPage
import com.example.finalproject001.screen.mainmenu.CartPage
import com.example.finalproject001.screen.mainmenu.HomePage
import com.example.finalproject001.screen.mainmenu.NotificationPage


@Composable
fun MainMenuScreen(modifier : Modifier = Modifier, navController: NavController) {

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home,0),
        NavItem("Notifications", Icons.Default.Notifications,0),
        NavItem("Cart", Icons.Default.ShoppingCart,0),
        NavItem("Account", Icons.Default.AccountCircle,0),
    )

    var selectedIndex by remember{
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected =  selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if(navItem.badgeCount>0)
                                    Badge(){
                                        Text(text = navItem.badgeCount.toString())
                                    }
                            }) {
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            }
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        },
    ) { innerPadding ->
        ContentScreen(navController = navController,modifier = Modifier.padding(innerPadding), selectedIndex)

    }
}

@Composable
fun Badge(content: @Composable () -> Unit) {
}


@Composable
fun ContentScreen(navController: NavController, modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex){
        0-> HomePage()
        1-> NotificationPage()
        2-> CartPage(navController)
        3-> AccountPage(navController)
    }
}