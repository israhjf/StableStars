package com.sandlot.stablestars.dashboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BasicTasksViewModel : ViewModel() {
    private val _tasks = MutableStateFlow(
        listOf(
            Task("Feed horses", false),
            Task("Clean stalls", false),
            Task("Provide fresh water", false),
            Task("Muck out paddocks", false),
            Task("Check fences for damage", false)
        )
    )
    val tasks: StateFlow<List<Task>> get() = _tasks

    fun toggleTask(taskName: String) {
        viewModelScope.launch {
            val updatedTasks = _tasks.value.map { task ->
                if (task.name == taskName) {
                    task.copy(isChecked = !task.isChecked)
                } else {
                    task
                }
            }
            _tasks.value = updatedTasks
        }
    }
}

data class Task(val name: String, val isChecked: Boolean)
