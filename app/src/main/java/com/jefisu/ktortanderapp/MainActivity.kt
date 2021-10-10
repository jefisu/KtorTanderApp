package com.jefisu.ktortanderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.jefisu.ktortanderapp.features.presentation.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Navigation(navController = navController)
        }
    }
}

