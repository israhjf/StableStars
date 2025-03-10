package com.sandlot.stablestars

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sandlot.stablestars.navigation.AppView
import com.sandlot.stablestars.navigation.BottomNavigationBar
import com.sandlot.stablestars.navigation.Navigation
import com.sandlot.stablestars.ui.theme.StableStarsTheme

@Composable
fun CreeksideEquestrianApp() {
    val navController = rememberNavController()
    val startScreen = AppView.Dashboard

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        Navigation(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startScreen = startScreen
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CreeksideEquestrianAppPreview() {
    StableStarsTheme {
        CreeksideEquestrianApp()
    }
}
