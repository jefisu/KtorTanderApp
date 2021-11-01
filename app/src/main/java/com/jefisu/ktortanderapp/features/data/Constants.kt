package com.jefisu.ktortanderapp.features.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import com.jefisu.ktortanderapp.features.data.model.BottomNavItem
import com.jefisu.ktortanderapp.features.presentation.util.Screen

object Constants {

    private const val BASE_URL = "http://192.168.0.2:8080"
    const val MEMBERS = "$BASE_URL/members"
    const val MEMBER = "$BASE_URL/member"

    val NavItems = listOf(
        BottomNavItem(title = "Home", route = Screen.Home.route, icon = Icons.Default.Home),
        BottomNavItem(title = "Profile", route = Screen.Profile.route, icon = Icons.Default.Person),
        BottomNavItem(title = "Settings", route = Screen.Settings.route, icon = Icons.Default.Settings)
    )
}