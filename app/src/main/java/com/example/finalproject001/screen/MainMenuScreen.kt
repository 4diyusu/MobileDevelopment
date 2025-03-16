package com.example.finalproject001.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.finalproject001.NavItem
import com.example.finalproject001.ProductViewModelFactory
import com.example.finalproject001.data.ProductRepository
import com.example.finalproject001.data.ProductViewModel
import com.example.finalproject001.viewmodel.CartViewModel
import com.example.finalproject001.screen.mainmenu.AccountPage
import com.example.finalproject001.screen.mainmenu.CartPage
import com.example.finalproject001.screen.mainmenu.HomePage
import com.example.finalproject001.screen.mainmenu.ServicesPage

@Composable
fun MainMenuScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    cartViewModel: CartViewModel
) {
    val cartItems by cartViewModel.cartItems.collectAsState()

    // ✅ Initialize ProductViewModel correctly
    val productViewModel: ProductViewModel = viewModel(
        factory = ProductViewModelFactory(ProductRepository())
    )

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Services", Icons.Default.Print, 0),
        NavItem("Cart", Icons.Default.ShoppingCart, 0),
        NavItem("Account", Icons.Default.AccountCircle, 0),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if (navItem.badgeCount > 0)
                                    Badge {
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
        ContentScreen(
            navController = navController,
            cartViewModel = cartViewModel,
            productViewModel = productViewModel, // ✅ Pass ProductViewModel
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex
        )
    }
}

@Composable
fun Badge(content: @Composable () -> Unit) {
}

@Composable
fun ContentScreen(
    navController: NavController,
    cartViewModel: CartViewModel,
    productViewModel: ProductViewModel, // ✅ Accept ProductViewModel
    modifier: Modifier = Modifier,
    selectedIndex: Int
) {
    when (selectedIndex) {
        0 -> HomePage(modifier, productViewModel, navController) // ✅ Pass ProductViewModel correctly
        1 -> ServicesPage(modifier, navController)
        2 -> CartPage(navController, cartViewModel)
        3 -> AccountPage(navController)
    }
}
