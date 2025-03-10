package com.sandlot.stablestars.navigation

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface, // Background color for the navigation bar
        tonalElevation = 0.dp // Ensure the elevation matches the surface color
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val currentRouteClassName = currentRoute?.substringAfterLast(".")
        Log.d("TEST", "currentRouteClassName: $currentRouteClassName")
        Log.d("TEST", "currentRoute: ${AppView.Dashboard.toString()}")

        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentRouteClassName == AppView.Dashboard.toString(),
            onClick = { navController.navigate(AppView.Dashboard) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary, // Green when selected
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant, // Muted when unselected
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer // Background for selected item
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Leaderboard") },
            label = { Text("Leaderboard") },
            selected = currentRouteClassName == AppView.Leaderboard.toString(),
            onClick = { navController.navigate(AppView.Leaderboard) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )

        NavigationBarItem(
            icon = { Icon(Icons.Default.Email, contentDescription = "Contact Admin") },
            label = { Text("Contact Admin") },
            selected = currentRouteClassName == AppView.ContactAdmin.toString(),
            onClick = { navController.navigate(AppView.ContactAdmin) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}


