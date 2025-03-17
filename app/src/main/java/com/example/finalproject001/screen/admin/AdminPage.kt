package com.example.finalproject001.screen.admin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.finalproject001.data.ProductViewModel
import com.example.finalproject001.screen.admin.AdminOptionsScreen
import com.example.finalproject001.screen.admin.ProductsManagementScreen
import com.example.finalproject001.screen.admin.TransactionsScreen
import com.example.finalproject001.screen.admin.UsersManagementScreen
import com.example.finalproject001.viewmodel.AdminViewModel
import com.example.finalproject001.viewmodel.TransactionViewModel

@Composable
fun AdminPage(navController: NavController, adminViewModel: AdminViewModel, productViewModel: ProductViewModel, transactionViewModel: TransactionViewModel) {
    val navItemList = listOf(
        NavItem("Users", Icons.Default.Group),
        NavItem("Transactions", Icons.Default.ShoppingBag),
        NavItem("Products", Icons.Default.List),
        NavItem("Options", Icons.Default.Settings),
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(text = navItem.label, fontSize = 12.sp)
                            }
                        },
                        label = { Text("") },
                        alwaysShowLabel = false
                    )
                }
            }
        },
    ) { innerPadding ->
        ContentScreen(
            navController = navController,
            adminViewModel = adminViewModel,
            productViewModel = productViewModel,
            transactionViewModel = transactionViewModel,
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex
        )
    }
}


@Composable
fun ContentScreen(
    navController: NavController,
    adminViewModel: AdminViewModel,
    modifier: Modifier = Modifier,
    productViewModel: ProductViewModel,
    transactionViewModel: TransactionViewModel,
    selectedIndex: Int
) {
    when (selectedIndex) {
        0 -> UsersManagementScreen()
        1 -> TransactionsScreen(navController, transactionViewModel)
        2 -> ProductsManagementScreen(navController, productViewModel)
        3 -> AdminOptionsScreen(navController)
    }
}

data class NavItem(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
