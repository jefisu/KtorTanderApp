package com.jefisu.ktortanderapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.jefisu.ktortanderapp.features.presentation.util.BottomNavBar
import com.jefisu.ktortanderapp.features.presentation.util.NavGraph
import com.jefisu.ktortanderapp.features.presentation.util.Screen
import com.jefisu.ktortanderapp.features.presentation.util.ShowBottomNav
import com.jefisu.ktortanderapp.ui.theme.KtorTanderAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtorTanderAppTheme {
                val navController = rememberNavController()
                ShowBottomNav(navController)
            }
        }
    }
}

