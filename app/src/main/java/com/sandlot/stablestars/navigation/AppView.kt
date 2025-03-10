package com.sandlot.stablestars.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class AppView() {

    @Serializable
    data object Dashboard: AppView()

    @Serializable
    data object BasicTasks: AppView()

    @Serializable
    data object IntermediateTasks: AppView()

    @Serializable
    data object AdvancedTasks: AppView()

    @Serializable
    data object Leaderboard: AppView()

    @Serializable
    data object Contact: AppView()

//    @Serializable
//    class ViewWithArg(val arg: String): AppView()

}