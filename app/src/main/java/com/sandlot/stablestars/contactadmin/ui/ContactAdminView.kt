package com.sandlot.stablestars.contactadmin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ContactAdminView(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(16.dp)
    ){
        ContactAdminViewBody()
    }
}

@Composable
fun ContactAdminViewBody(
    viewModel: ContactAdminViewModel = viewModel()
) {
    val message by viewModel.message.collectAsState() // Collect StateFlow as state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Text Field for Message
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Covers half of the screen vertically
            value = message, // Use collected message state here
            onValueChange = { viewModel.updateMessage(it) }, // Update ViewModel state
            label = { Text("Message") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            maxLines = 10 // Allows multiple lines of text
        )

        // Submit Button
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.submitMessage() }
        ) {
            Text("Submit")
        }
    }
}