package com.sandlot.stablestars.contactadmin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ContactAdminViewModel : ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> get() = _message

    fun updateMessage(newMessage: String) {
        _message.value = newMessage
    }

    fun submitMessage() {
        // Handle message submission logic here
        viewModelScope.launch {
            // Simulate a network request or database operation
            // Replace with actual submission logic
            println("Message submitted: ${message.value}")
        }
    }
}
