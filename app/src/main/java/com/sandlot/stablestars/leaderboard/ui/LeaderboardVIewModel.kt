package com.sandlot.stablestars.leaderboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandlot.stablestars.common.models.Farmhand
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class LeaderboardViewModel : ViewModel() {
    private val _farmhands = MutableStateFlow(
        listOf(
            Farmhand("Alice", 120),
            Farmhand("Bob", 110),
            Farmhand("Charlie", 100),
            Farmhand("David", 90),
            Farmhand("Eve", 80),
            Farmhand("Frank", 70)
        )
    )
    val farmhands: StateFlow<List<Farmhand>> get() = _farmhands

    val topThreeFarmhands: StateFlow<List<Farmhand>> = farmhands
        .map { farmhands ->
            farmhands.sortedByDescending { it.points }.take(3)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val remainingFarmhands: StateFlow<List<Farmhand>> = farmhands
        .map { farmhands ->
            farmhands.sortedByDescending { it.points }.drop(3)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}
