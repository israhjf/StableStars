package com.sandlot.stablestars.dashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
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
import com.sandlot.stablestars.navigation.AppView

@Composable
fun DashboardView(
    navController: NavController,
    dashboardVM: DashboardViewModel = viewModel()
) {
    Column{
        DashboardHeader()
        DashboardBody(navController)
    }
}

@Composable
fun DashboardHeader(){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        text = "Creekside Equestrian",
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Composable
fun DashboardBody(
    navController: NavController
){
    val currentPoints: Int by remember { mutableStateOf(50) }
    val totalPoints: Int by remember { mutableStateOf(100) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NotificationCard()

        TaskCard(title = "Basic", pointsRange = "1-5 pts") {
            navController.navigate(AppView.BasicTasks)
        }
        TaskCard(title = "Intermediate", pointsRange = "6-10 pts") {
            navController.navigate("intermediate_tasks")
        }
        TaskCard(title = "Advanced", pointsRange = "11-15 pts") {
            navController.navigate("advanced_tasks")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Points Display
        Text(
            text = "${currentPoints} pts / ${totalPoints}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun NotificationCard(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
//            Icon(
//                imageVector = Icons.Default.CheckCircle,
//                contentDescription = null,
//                tint = MaterialTheme.colorScheme.primary // Green accent icon
//            )
            Icon(Icons.Default.Notifications, contentDescription = "notifications")
            Text(
                text = "There are 9 available tasks!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Composable
fun TaskCard(title: String, pointsRange: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = pointsRange,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}


