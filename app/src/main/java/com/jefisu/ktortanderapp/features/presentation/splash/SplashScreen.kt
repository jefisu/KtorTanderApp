package com.jefisu.ktortanderapp.features.presentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jefisu.ktortanderapp.R
import com.jefisu.ktortanderapp.features.presentation.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1000L)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_tander),
            contentDescription = "Icon tander",
            modifier = Modifier
                .size(160.dp)
                .alpha(
                    animateFloatAsState(
                        targetValue = if (startAnimation) 1f else 0f,
                        animationSpec = tween(durationMillis = 1000)
                    ).value
                )
        )
    }
}