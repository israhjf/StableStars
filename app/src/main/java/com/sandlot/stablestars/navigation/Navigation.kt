package com.sandlot.stablestars.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sandlot.stablestars.dashboard.ui.DashboardView

@Composable
fun Navigation(
    modifier: Modifier,
    navController: NavHostController,
    startScreen: AppView
) {

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startScreen,
    ) {
        composable<AppView.Dashboard> { DashboardView(navController) }
//        composable<AppView.BasicTasks> { BasicTasksView() }
//        composable<AppView.IntermediateTasks> { IntermediateTasksView() }
//        composable<AppView.AdvancedTasks> { AdvancedTasksView() }
//        composable<AppView.Leaderboard> { LeaderboardView() }
//        composable<AppView.Contact> { ContactAdminView() }
    }
}
