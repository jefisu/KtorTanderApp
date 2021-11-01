package com.jefisu.ktortanderapp.features.presentation.util

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Detail : Screen("detail_screen")
    object Profile : Screen("profile_screen")
    object Settings : Screen("settings_screen")

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
