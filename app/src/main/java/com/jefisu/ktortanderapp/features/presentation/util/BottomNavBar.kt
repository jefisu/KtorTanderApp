package com.jefisu.ktortanderapp.features.presentation.util

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jefisu.ktortanderapp.features.data.Constants

@ExperimentalMaterialApi
@Composable
fun BottomNavBar(
    navController: NavController
) {
    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        Constants.NavItems.forEach { navItem ->
            val selected = navItem.route == navBackStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (navItem.count > 0) {
                            BadgeBox(badgeContent = {
                                Text(text = navItem.title)
                            }) {
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
                        popUpTo(Constants.NavItems[0].route)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}