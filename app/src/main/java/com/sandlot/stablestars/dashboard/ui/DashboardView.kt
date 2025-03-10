package com.sandlot.stablestars.dashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun DashboardView(
    navController: NavController,
    dashboardVM: DashboardViewModel = viewModel()
) {
    val currentPoints: Int by remember { mutableStateOf(50) }
    val totalPoints: Int by remember { mutableStateOf(100) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Creekside Equestrian",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Current Tasks", style = MaterialTheme.typography.bodyMedium)

        // Task Cards
        TaskCard(title = "Basic", pointsRange = "1-5 pts") {
            navController.navigate("basic_tasks")
        }
        TaskCard(title = "Intermediate", pointsRange = "6-10 pts") {
            navController.navigate("intermediate_tasks")
        }
        TaskCard(title = "Advanced", pointsRange = "11-15 pts") {
            navController.navigate("advanced_tasks")
        }

        Spacer(modifier = Modifier.weight(1f))
        Text(text = "${currentPoints} pts / ${totalPoints}", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun TaskCard(title: String, pointsRange: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(text = pointsRange, style = MaterialTheme.typography.bodySmall)
        }
    }
}
