package com.jefisu.ktortanderapp.features.presentation.util

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jefisu.ktortanderapp.features.data.model.BottomNavItem
import com.jefisu.ktortanderapp.features.presentation.home.HomeViewModel

@ExperimentalMaterialApi
@Composable
fun BottomNavBar(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val navItems = listOf(
        BottomNavItem(
            title = "Home",
            route = Screen.Home.route,
            icon = Icons.Default.Home,
            count = viewModel.state.value.count
        ),
        BottomNavItem(
            title = "Profile",
            route = Screen.Profile.route,
            icon = Icons.Default.Person
        ),
        BottomNavItem(
            title = "Settings",
            route = Screen.Settings.route,
            icon = Icons.Default.Settings
        )
    )
    BottomNavigation(
        modifier = Modifier.graphicsLayer {
            shape = RoundedCornerShape(
                topStart = 20.dp,
                topEnd = 20.dp
            )
            clip = true
        }
    ) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        navItems.forEach { navItem ->
            val selected = navItem.route == navBackStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (navItem.count > 0) {
                            BadgeBox(
                                badgeContent = {
                                    Text(text = navItem.count.toString())
                                }
                            ) {
                                Icon(
                                    imageVector = navItem.icon,
                                    contentDescription = navItem.title
                                )
                            }
                        } else {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = navItem.title
                            )
                        }
                        if (selected) {
                            Text(
                                text = navItem.title,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                },
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navItems[0].route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}