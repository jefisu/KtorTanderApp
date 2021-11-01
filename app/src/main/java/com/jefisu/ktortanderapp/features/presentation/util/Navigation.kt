package com.jefisu.ktortanderapp.features.presentation.util

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.jefisu.ktortanderapp.features.presentation.detail.DetailScreen
import com.jefisu.ktortanderapp.features.presentation.home.HomeScreen
import com.jefisu.ktortanderapp.features.presentation.profile.ProfileScreen
import com.jefisu.ktortanderapp.features.presentation.settings.SettingsScreen

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { entry ->
            val id = entry.arguments?.getInt("id")
            id?.let {
                DetailScreen(id = it, navController = navController)
            }
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen()
        }
    }
}