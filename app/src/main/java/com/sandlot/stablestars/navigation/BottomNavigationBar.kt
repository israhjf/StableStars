package com.sandlot.stablestars.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = false,
            onClick = { navController.navigate("dashboard") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Leaderboard") },
            label = { Text("Leaderboard") },
            selected = false,
            onClick = { navController.navigate("leaderboard") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Email, contentDescription = "Contact Admin") },
            label = { Text("Contact Admin") },
            selected = false,
            onClick = { navController.navigate("contact_admin") }
        )
    }
}
